package com.training.action;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.training.model.Goods;
import com.training.service.BackEndService;
import com.training.formbean.BackendformData;
import com.training.vo.SalesReport;

@MultipartConfig
public class BackendAction extends DispatchAction {
	
	private BackEndService backEndService = BackEndService.getInstance();
       
	//商品列表的方法
	public ActionForward queryGoods(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) {
		
		Set<Goods> goodsList = backEndService.queryGoods();
		goodsList.stream().forEach(g -> System.out.println(g));
		
		// 結束後顯示頁面
		return mapping.findForward("GoodListView");
	}
	
	//商品維護作業的重導頁面
	public ActionForward updateGoodsView(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return mapping.findForward("GoodsReplenishmentView");
		
	}
	//商品維護作業的方法
	public ActionForward updateGoods(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 將表單資料使用 struts ActionForm 方式自動綁定，省去多次由 request getParameter 取表單資料的工作
		BackendformData formData = (BackendformData) form;
		// 將Struts BackedActionForm 資料複製 Goods
		// 將表單資料轉換儲存資料物件(commons-beanutils-1.8.0.jar)
		Goods goods = new Goods();
		BeanUtils.copyProperties(goods, formData);
				
		boolean updateSuccess = backEndService.updateGoods(goods);
		String message = updateSuccess ? "資料修改成功！" : "資料修改失敗！";
		System.out.println(message);
		
		//做完顯示回原本GoodsReplenishment頁面
		return mapping.findForward("GoodsReplenishment");
	}
	
	//商品新增的重導頁面
	public ActionForward createGoodsView(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception{
		return mapping.findForward("GoodsCreateView");
	}
	//商品新增的方法
	public ActionForward createGoods(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		BackendformData formData = (BackendformData) form;		
		Goods goods = new Goods();
		BeanUtils.copyProperties(goods, formData);
		
		
		int goodsID = backEndService.createGoods(goods);
		if(goodsID > 0){ System.out.println("商品新增上架成功！ 商品編號：" + goodsID); }
		

		return mapping.findForward("GoodsCreate");	
	}
	
	//銷售報表的方法
	public ActionForward querySalesReport(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception{		
		
		BackendformData formData = (BackendformData) form;
		String startDate = formData.getQueryStartDate();
		String endDate = formData.getQueryEndDate();
		
	
		//做完顯示回原本GoodsSaleReportView頁面
		return mapping.findForward("GoodsSaleReportView");
	}
	

}
