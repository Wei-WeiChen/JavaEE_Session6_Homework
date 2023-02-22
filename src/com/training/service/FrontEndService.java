package com.training.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.training.dao.BackEndDao;
import com.training.dao.FrontEndDao;
import com.training.model.Goods;
import com.training.model.Member;

public class FrontEndService {

	private static FrontEndService frontEndService = new FrontEndService();
	
	private FrontEndService (){}
	
	private static FrontEndDao frontEndDao= FrontEndDao.getInstance();
	
	public static FrontEndService getInstance() {
		return frontEndService;
	}
		
	public static  Set<Goods> searchGoods(String searchKey, int i) { //查詢&分頁查詢
		
		if(searchKey==null){
			searchKey = "";
		}
		int endPage = i*6;
		int startPage = endPage-5;
		return frontEndDao.searchGoods(searchKey, startPage, endPage);
	}

	public static Map<Integer, Goods> queryBuyGoods(Set<Integer> goodsIDs) {
		
		return frontEndDao.queryBuyGoods(goodsIDs);
	}

	public Member queryMemberByIdentificationNo(String customerID) {
		
		return frontEndDao.queryMemberByIdentificationNo(customerID);
	}

	public boolean batchCreateGoodsOrder(String customerID,Map<Goods, Integer> goodsOrders) {
		
		return frontEndDao.batchCreateGoodsOrder(customerID, goodsOrders);
	}

	public int buySum(Map<Goods, Integer> goodsOrders) { //購買總額
		int totalCost = 0;
		
		for(Map.Entry<Goods,Integer>entry:goodsOrders.entrySet()){
			totalCost += entry.getKey().getGoodsPrice()*entry.getValue();
		}
		return totalCost;
	}

	public List<Goods> buyTotalQuantity(Map<Goods, Integer> goodsOrders) {//購買商品與數量
		List<Goods> buyGoods = new ArrayList<>();
		
		for(Map.Entry<Goods,Integer>entry:goodsOrders.entrySet()){
			Goods good =new Goods();
			good.setGoodsID(entry.getKey().getGoodsID());
			good.setGoodsName(entry.getKey().getGoodsName());
			good.setGoodsPrice(entry.getKey().getGoodsPrice());
			good.setGoodsQuantity(entry.getValue());
			buyGoods.add(good);
		}
		return buyGoods;
	}

	public boolean batchUpdateGoodsQuantity(Set<Goods> collect) {// 將顧客所購買商品扣除更新商品庫存數量
//		Set<Goods> buyGoods = new HashSet<>();
//		
//		for(Map.Entry<Goods,Integer>entry : ){
//			
//		}
		
		return frontEndDao.batchUpdateGoodsQuantity(collect);
	}

	

	
	
	
	
//	public static void main(String[] args) {
//				
//		// 請先執行 BEVERAGE.sql 至 Local DB
//		FrontEndDao frontEndDao = FrontEndDao.getInstance();
//		
//		// 1.前臺顧客登入查詢
//		String customerID = "D201663865";
//		Member member = frontEndDao.queryMemberByIdentificationNo(customerID);
//		System.out.println(member);
//		System.out.println("----------------------------------------");
//		
//		// 2.前臺顧客瀏灠商品
//		Set<Goods> goods = frontEndDao.searchGoods("ca", 6, 13);
//		goods.stream().forEach(g -> System.out.println(g));
//		System.out.println("----------------------------------------");
//		
//		// 3.前臺顧客購買建立訂單
//		// Step1:查詢顧客所購買商品資料(價格、庫存)
//		Set<BigDecimal> goodsIDs = new HashSet<>();
//		goodsIDs.add(new BigDecimal("19"));
//		goodsIDs.add(new BigDecimal("20"));
//		Map<BigDecimal, Goods> buyGoods = frontEndDao.queryBuyGoods(goodsIDs);
//		buyGoods.values().stream().forEach(g -> System.out.println(g));		
//		
//		// Step2:建立訂單資料
//		// 訂單資料(key:購買商品、value:購買數量)
//		int buyQuantity = 2; // 購買數量皆為2
//		Map<Goods,Integer> goodsOrders = new HashMap<>();
//		goodsIDs.stream().forEach(goodsID -> {
//			Goods g = buyGoods.get(goodsID);			
//			goodsOrders.put(g, buyQuantity); 
//		});
//		// 建立訂單
//		boolean insertSuccess = frontEndDao.batchCreateGoodsOrder(customerID, goodsOrders);
//		if(insertSuccess){System.out.println("建立訂單成功!");}
//		
//		// Step3:交易完成更新扣商品庫存數量
//		// 將顧客所購買商品扣除更新商品庫存數量
//		buyGoods.values().stream().forEach(g -> g.setGoodsQuantity(g.getGoodsQuantity() - buyQuantity));
//		boolean updateSuccess = frontEndDao.batchUpdateGoodsQuantity(buyGoods.values().stream().collect(Collectors.toSet()));
//		if(updateSuccess){System.out.println("商品庫存更新成功!");}
//		
//	}

}
