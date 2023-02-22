package com.training.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.training.model.Goods;
import com.training.model.Member;
import com.training.service.BackEndService;
import com.training.service.FrontEndService;
import com.training.vo.BuyGoodsRtn;
import com.training.formbean.GoodsOrderFrom;


public class FrontendAction extends DispatchAction {

	private FrontEndService frontEndService = FrontEndService.getInstance();
    


	public ActionForward searchGoods (ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) {
		
		Set<Goods> goods = FrontEndService.searchGoods(request.getParameter("searchKeyword"), Integer.parseInt(request.getParameter("pageNo")));
		goods.stream().forEach(g -> System.out.println(g));
		
				
		return mapping.findForward("VendingMachine");
	}

	public ActionForward buyGoods(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) {
		
		String customerID = request.getParameter("customerID"); //客戶登入資料
		Member member = frontEndService.queryMemberByIdentificationNo(customerID);
		System.out.println(member);
		//------------------------------------------------------------------

		Set<Integer> goodsIDs = new HashSet<>();
		
		String[] goodsID= request.getParameterValues("goodsID");//選擇商品
		String[] buyQuantity= request.getParameterValues("buyQuantity");// 購買數量
		
		for(int i =0;i<6;i++){
			goodsIDs.add(Integer.parseInt(goodsID[i]));			
		}
		
		Map<Integer, Goods> buyGoods = FrontEndService.queryBuyGoods(goodsIDs);
//		buyGoods.values().stream().forEach(g -> System.out.println(g)); 
//		System.out.println("-----------------------------------------");
		
		Map<Goods,Integer> goodsOrders = new HashMap<>();
			
		for(int i =0;i<6;i++){
			if(Integer.parseInt(buyQuantity[i])!=0){ //數量0去掉
			goodsOrders.put(buyGoods.get(Integer.parseInt(goodsID[i])), Integer.parseInt(buyQuantity[i]));	
			}
		}
		
		for(Goods goods : goodsOrders.keySet()){
			System.out.println(goods); //查庫存
		}
		
		boolean insertSuccess = frontEndService.batchCreateGoodsOrder(customerID, goodsOrders);//建立訂單
		
		int inputMoney = Integer.parseInt(request.getParameter("inputMoney"));//投入金額
		System.out.println("投入金額:"+inputMoney);
		
		int buySum = frontEndService.buySum(goodsOrders);//購買金額
		System.out.println("購買總金額:"+buySum);
		
		if(inputMoney - buySum < 0){     //選購總金額 大於 投入金額			
			int giveChange = inputMoney;
			System.out.println("金額不足，請重新購買");
			System.out.println("找零金額:"+giveChange);		
		}
			
		int giveChange = inputMoney - buySum;//找零金額
		System.out.println("找零金額:"+giveChange);
		
		List<Goods> buyTotalQuantity = frontEndService.buyTotalQuantity(goodsOrders);//購買商品與數量
		System.out.println("購買清單:");
		buyTotalQuantity.forEach(b->System.out.println("商品名稱:"+b.getGoodsName() + " 商品金額:"+b.getGoodsPrice() + " 購買數量:"+b.getGoodsQuantity()));
		
		
		if(insertSuccess){System.out.println("建立訂單成功!");}
		
//		 將顧客所購買商品扣除更新商品庫存數量
		buyGoods.values().stream().forEach(g -> g.setGoodsQuantity(g.getGoodsQuantity() ));//問題 goodsOrders 的數量
		boolean updateSuccess = frontEndService.batchUpdateGoodsQuantity(buyGoods.values().stream().collect(Collectors.toSet()));
		if(updateSuccess){System.out.println("商品庫存更新成功!");}
		
			
		
//		String[] goodsID= req.getParameterValues("goodsID");//選擇商品
//		String[] buyQuantity= req.getParameterValues("buyQuantity");// 購買數量
//		
//		Map<Integer,Integer> goodsOrders = new HashMap<>(); //商品數量對應的MAP		
//		for(int i =0;i<6;i++){
//			goodsOrders.put(Integer.parseInt(goodsID[i]), Integer.parseInt(buyQuantity[i]));
//		}
//		
//		//列出有購買數量的商品
//		Set<Goods> buyGoodsList = BuyGoodsRtn.buyGoodsList(goodsOrders);		
//		buyGoodsList.forEach(g -> System.out.println(g));
//		
//		//計算購買總額
//		int buySum = BuyGoodsRtn.buySum(buyGoodsList);
//		System.out.println("購買總金額:"+buySum);		
				
		
		
		// Redirect to view
		return mapping.findForward("VendingMachine");
		
	}


}

