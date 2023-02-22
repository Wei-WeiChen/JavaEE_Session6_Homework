package com.training.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.training.model.Goods;
import com.training.vo.SalesReport;
import com.training.dao.DBConnectionFactory;

public class BackEndDao {
	
	private static BackEndDao backendDao = new BackEndDao();
	
	private BackEndDao(){ }

	public static BackEndDao getInstance(){
		return backendDao;
	}
	
	/**
	 * 後臺管理商品列表
	 * @return Set(Goods)
	 */
	public Set<Goods> queryGoods() {
		Set<Goods> goods = new LinkedHashSet<>(); 
		String querySQL = "SELECT * FROM BEVERAGE_GOODS";
		try(Connection conn=DBConnectionFactory.getOracleDBConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(querySQL)){
				while(rs.next()){
					Goods good= new Goods();
					good.setGoodsID(rs.getInt("GOODS_ID"));
					good.setGoodsName(rs.getString("GOODS_NAME"));
					good.setGoodsPrice(rs.getInt("PRICE"));
					good.setGoodsQuantity(rs.getInt("QUANTITY"));
					good.setGoodsImageName(rs.getString("IMAGE_NAME"));
					good.setStatus(rs.getString("STATUS"));
					goods.add(good);					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return goods;
		
		
	}
	
	
	/**
	 * 後臺管理新增商品
	 * @param goods
	 * @return int(商品編號)
	 */
	public int createGoods(Goods goods){
		int goodsID = 0;
		String[] cols={"GOODS_ID"};
		try(Connection conn = DBConnectionFactory.getOracleDBConnection()){
			conn.setAutoCommit(false);
			String insertSQL="INSERT INTO BEVERAGE_GOODS (GOODS_ID,GOODS_NAME,PRICE,QUANTITY,IMAGE_NAME,STATUS) VALUES (BEVERAGE_GOODS_SEQ.NEXTVAL,?,?,?,?,?)";
			
			try(PreparedStatement pstmt = conn.prepareStatement(insertSQL,cols)){
				
				pstmt.setString(1, goods.getGoodsName());
				pstmt.setInt(2, goods.getGoodsPrice());
				pstmt.setInt(3, goods.getGoodsQuantity());
				pstmt.setString(4, goods.getGoodsImageName());
				pstmt.setString(5, goods.getStatus());			
				int count=pstmt.executeUpdate();
				
				if(count==0){
					conn.setAutoCommit(false);
				}
//				createSuccess = (recordCount>0) ? true : false;
				
				ResultSet rsKeys=pstmt.getGeneratedKeys();
				rsKeys.next();
				goodsID=rsKeys.getInt(1);
								
			}catch(SQLException e){
				conn.rollback();
				throw e;
			}
			conn.commit();
		} catch (SQLException e) {
//			createSuccess = false;
			e.printStackTrace();
		}
		return goodsID ;
	}
	
	/**
	 * 後臺管理更新商品
	 * @param goods
	 * @return boolean
	 */
	public boolean updateGoods(Goods goods) {
		boolean updateSuccess = false;
		try (Connection conn= DBConnectionFactory.getOracleDBConnection()){
			conn.setAutoCommit(false);
			String updateSql="UPDATE BEVERAGE_GOODS SET PRICE=?,QUANTITY=QUANTITY+?,STATUS=? WHERE GOODS_ID=?";
			
			try(PreparedStatement stmt=conn.prepareStatement(updateSql)){
//				stmt.setString(1, goods.getGoodsName());
				stmt.setInt(1, goods.getGoodsPrice());
				stmt.setInt(2, goods.getGoodsQuantity());
//				stmt.setString(4, goods.getGoodsImageName());
				stmt.setString(3, goods.getStatus());
				stmt.setInt(4, goods.getGoodsID());				
				int count=stmt.executeUpdate();
				
				if(count==0){
					updateSuccess=false;
				}else{
					updateSuccess=true;
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
	 * 後臺管理刪除商品
	 * @param goodsID
	 * @return boolean
	 */
	public boolean deleteGoods(BigDecimal goodsID) {
		boolean deleteSuccess = false;
		
		try(Connection conn=DBConnectionFactory.getOracleDBConnection()){
			conn.setAutoCommit(false);
			String deleteSql="DELETE FROM BEVERAGE_GOODS WHERE GOODS_ID=?";
			
			try(PreparedStatement stmt=conn.prepareStatement(deleteSql)){
				stmt.setBigDecimal(1, goodsID);
				int count=stmt.executeUpdate();
				
				if(count==0){
					deleteSuccess=false;
				}else{
					deleteSuccess=true;
				}
								
			}catch(SQLException e){
				conn.rollback();
				throw e;
			}
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return deleteSuccess;
	}
	
	/**
	 * 後臺管理顧客訂單查詢
	 * @param queryStartDate
	 * @param queryEndDate
	 * @return Set(SalesReport)
	 */
	public Set<SalesReport> queryOrderBetweenDate(String queryStartDate, String queryEndDate) {
		Set<SalesReport> reports = new LinkedHashSet<>();
		String querySQL = " WITH R AS(";
				querySQL+=" SELECT O.ORDER_ID,M.CUSTOMER_NAME,O.ORDER_DATE,G.GOODS_NAME,O.GOODS_BUY_PRICE,O.BUY_QUANTITY,";
				querySQL+=" (O.GOODS_BUY_PRICE*O.BUY_QUANTITY)BUY_AMOUNT";
				querySQL+=" FROM BEVERAGE_ORDER O";
				querySQL+=" JOIN BEVERAGE_MEMBER M ON O.CUSTOMER_ID = M.IDENTIFICATION_NO";
				querySQL+=" JOIN BEVERAGE_GOODS G ON O.GOODS_ID = G.GOODS_ID";
				querySQL+=" )";
				querySQL+=" SELECT ORDER_ID,CUSTOMER_NAME,ORDER_DATE,GOODS_NAME,GOODS_BUY_PRICE,BUY_QUANTITY,BUY_AMOUNT";
				querySQL+=" FROM R";
				querySQL+=" WHERE ORDER_DATE >=TO_DATE(? ||' 00:00:00','YYYY-MM-DD HH24:MI:SS') AND ORDER_DATE <= TO_DATE(? || ' 23:59:59','YYYY-MM-DD HH24:MI:SS') ORDER BY ORDER_ID";

		try(Connection conn=DBConnectionFactory.getOracleDBConnection();
			PreparedStatement stmt=conn.prepareStatement(querySQL)){
			stmt.setString(1, queryStartDate);
			stmt.setString(2, queryEndDate);
			
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()){
					SalesReport report= new SalesReport();
					report.setOrderID(rs.getInt("ORDER_ID"));
					report.setCustomerName(rs.getString("CUSTOMER_NAME"));
					report.setOrderDate(rs.getString("ORDER_DATE"));
					report.setGoodsName(rs.getString("GOODS_NAME"));
					report.setGoodsBuyPrice(rs.getInt("GOODS_BUY_PRICE"));
					report.setBuyQuantity(rs.getInt("BUY_QUANTITY"));
					report.setBuyAmount(rs.getInt("BUY_AMOUNT"));
										
					reports.add(report);					
					}
				}catch(SQLException e){
					throw e;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return reports;
	}	
	
}
