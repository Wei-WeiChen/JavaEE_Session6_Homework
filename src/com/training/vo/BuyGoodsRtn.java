package com.training.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.dao.DBConnectionFactory;
import com.training.model.Goods;

public class BuyGoodsRtn {
	

}


//將兩個讀取的陣列放到Set<Goods>
//public static Set<Goods> buyGoodsList(Map<Integer,Integer> goodsOrders){
//	Set<Goods> GoodsChoose = new HashSet<>();
//	
//	for(Integer key : goodsOrders.keySet()){
//		
//		String querrySQL="SELECT * FROM BEVERAGE_GOODS WHERE GOODS_ID IN ?";			
//		try 
//		(Connection conn=DBConnectionFactory.getOracleDBConnection();
//		PreparedStatement stmt=conn.prepareStatement(querrySQL)	){
//		stmt.setInt(1,key);
//		
//		try(ResultSet rs=stmt.executeQuery()){
//			while(rs.next()){
//				if(goodsOrders.get(key)!=0){
//				Goods good=new Goods();
//				good.setGoodsID(key);
//				good.setGoodsName(rs.getString("GOODS_NAME"));
//				good.setGoodsPrice(rs.getInt("PRICE"));
//				good.setGoodsQuantity(goodsOrders.get(key));
//				good.setGoodsImageName(rs.getString("IMAGE_NAME"));
//				good.setStatus(rs.getString("STATUS"));
//				GoodsChoose.add(good);
//				}
//			}
//		}catch(SQLException e){
//			throw e;
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//		
//	}
//	return GoodsChoose;	
//}

//算出客人選擇商品的總價
//public static int buySum(Set<Goods> buyGoodsList) {
//	int totalCost = 0;
//	for(Goods good : buyGoodsList){
//		totalCost += good.getGoodsPrice()*good.getGoodsQuantity();
//	}
//	return totalCost;
//}