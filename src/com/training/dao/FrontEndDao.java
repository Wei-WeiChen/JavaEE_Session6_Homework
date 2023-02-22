package com.training.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.training.dao.DBConnectionFactory;
import com.training.model.Goods;
import com.training.model.Member;

public class FrontEndDao {
	
	private static FrontEndDao backendDao = new FrontEndDao();
	
	
	private FrontEndDao(){ }

	public static FrontEndDao getInstance(){
		
		return backendDao;
	}
	
	/**
	 * 前臺顧客登入查詢
	 * @param identificationNo
	 * @return Member
	 */
	public Member queryMemberByIdentificationNo(String identificationNo){
		Member member = null;
		String querySQL="SELECT * FROM BEVERAGE_MEMBER WHERE IDENTIFICATION_NO=?";
		try(Connection conn=DBConnectionFactory.getOracleDBConnection();
			PreparedStatement stmt=conn.prepareStatement(querySQL)){
				stmt.setString(1, identificationNo);
				
				try(ResultSet rs=stmt.executeQuery()){
					while(rs.next()){
						member=new Member();
						member.setIdentificationNo(rs.getString("IDENTIFICATION_NO"));
						member.setCustomerName(rs.getString("CUSTOMER_NAME"));
						member.setPassword(rs.getString("PASSWORD"));
						break;
					}					
				}catch(SQLException e){
					throw e;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	/**
	 * 前臺顧客瀏灠商品
	 * @param searchKeyword
	 * @param startRowNo
	 * @param endRowNo
	 * @return Set(Goods)
	 */
	public Set<Goods> searchGoods(String searchKeyword, int startRowNo, int endRowNo) {
		Set<Goods> goods = new LinkedHashSet<>();
		String querrySQL="WITH R AS(SELECT GOODS_ID,GOODS_NAME,PRICE,QUANTITY,IMAGE_NAME,STATUS,"
				+ "ROW_NUMBER()OVER(ORDER BY GOODS_ID)ROWNU "
				+ "FROM BEVERAGE_GOODS WHERE LOWER(GOODS_NAME) LIKE ?)"
				+ "SELECT * FROM R WHERE ROWNU >= ? AND ROWNU <= ?";
//		System.out.println(querrySQL);
		try 
			(Connection conn=DBConnectionFactory.getOracleDBConnection();
			PreparedStatement stmt=conn.prepareStatement(querrySQL)){
			stmt.setString(1, "%"+searchKeyword+"%");
			stmt.setInt(2, startRowNo);
			stmt.setInt(3, endRowNo);
			
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()){
					Goods good=new Goods();
					good.setGoodsID(rs.getInt("GOODS_ID"));
					good.setGoodsName(rs.getString("GOODS_NAME"));
					good.setGoodsPrice(rs.getInt("PRICE"));
					good.setGoodsQuantity(rs.getInt("QUANTITY"));
					good.setGoodsImageName(rs.getString("IMAGE_NAME"));
					good.setStatus(rs.getString("STATUS"));
					goods.add(good);
				}
			}catch(SQLException e){
				throw e;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
	
	/**
	 * 查詢顧客所購買商品資料(價格、庫存)
	 * @param goodsIDs
	 * @return Map(Integer, Goods)
	 */
	public Map<Integer, Goods> queryBuyGoods(Set<Integer> goodsIDs){
		// key:商品編號、value:商品
		Map<Integer, Goods> goods = new LinkedHashMap<>();
			
		String querrySQL="SELECT * FROM BEVERAGE_GOODS WHERE GOODS_ID IN ?";
		
		  for(Integer goodsID:goodsIDs){
			try 
				(Connection conn=DBConnectionFactory.getOracleDBConnection();
				PreparedStatement stmt=conn.prepareStatement(querrySQL)	){
				stmt.setInt(1,goodsID);
				
				try(ResultSet rs=stmt.executeQuery()){
					while(rs.next()){
						Goods good=new Goods();
						good.setGoodsID(rs.getInt("GOODS_ID"));
						good.setGoodsName(rs.getString("GOODS_NAME"));
						good.setGoodsPrice(rs.getInt("PRICE"));
						good.setGoodsQuantity(rs.getInt("QUANTITY"));
//						good.setGoodsImageName(rs.getString("IMAGE_NAME"));
						good.setStatus(rs.getString("STATUS"));
						goods.put(rs.getInt("GOODS_ID"),good);
					}
				}catch(SQLException e){
					throw e;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goods;
	}
	
	/**
	 * 交易完成更新扣商品庫存數量
	 * @param goods
	 * @return boolean
	 */
	public boolean batchUpdateGoodsQuantity(Set<Goods> goods){
		boolean updateSuccess = false;
	
		try (Connection conn= DBConnectionFactory.getOracleDBConnection()){
			conn.setAutoCommit(false);
			
			String updateSql="UPDATE BEVERAGE_GOODS SET GOODS_NAME=?,PRICE=?,QUANTITY=? WHERE GOODS_ID=?";
			
			try(PreparedStatement stmt=conn.prepareStatement(updateSql)){
				
				for(Goods good:goods){
					stmt.setString(1, good.getGoodsName());
					stmt.setInt(2, good.getGoodsPrice());
					stmt.setInt(3, good.getGoodsQuantity());
//					stmt.setString(4, good.getGoodsImageName());
//					stmt.setString(5, good.getStatus());
					stmt.setInt(4, good.getGoodsID());			
					stmt.addBatch();
					}				
				int[] counts=stmt.executeBatch();
				
				for(int count : counts){
					if(count==-2){
						updateSuccess=true;
					}else{
						updateSuccess=false;
					}
				}				
			}catch(SQLException e){
				conn.rollback();
				throw e;
			}
			conn.commit();
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		return updateSuccess;
	}
	
	/**
	 * 建立訂單資料
	 * @param customerID
	 * @param goodsOrders【訂單資料(key:購買商品、value:購買數量)】
	 * @return boolean
	 */
	public boolean batchCreateGoodsOrder(String customerID, Map<Goods,Integer> goodsOrders){
		boolean insertSuccess = false;
		
		String[] cols={"ORDER_ID"};
		try(Connection conn = DBConnectionFactory.getOracleDBConnection()){
			
			conn.setAutoCommit(false);
			String insertSQL="INSERT INTO BEVERAGE_ORDER (ORDER_ID,ORDER_DATE,CUSTOMER_ID,GOODS_ID,GOODS_BUY_PRICE,BUY_QUANTITY) VALUES (BEVERAGE_ORDER_SEQ.NEXTVAL,SYSDATE,?,?,?,?)";
						
			try(PreparedStatement stmt = conn.prepareStatement(insertSQL)){	
				
				for(Map.Entry<Goods,Integer>entry:goodsOrders.entrySet()){
					stmt.setString(1, customerID);
					stmt.setInt(2, entry.getKey().getGoodsID());
					stmt.setInt(3,entry.getKey().getGoodsPrice());
					stmt.setInt(4, entry.getValue());
					stmt.addBatch();
				}					
				int[] counts=stmt.executeBatch();		
				for(int count : counts){
					if(count==-2){
						insertSuccess = true;
					}	
				}								
			}catch(SQLException e){
				conn.rollback();
				throw e;
			}
			conn.commit();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return insertSuccess;
	}	

}
