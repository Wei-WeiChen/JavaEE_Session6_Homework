<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-tw">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>販賣機-後臺</title>
	<script type="text/javascript">

	</script>
</head>
<body>
	<h1>Vending Machine Backend Service</h1><br/>		
	<table border="1" style="border-collapse:collapse;;margin-left:25px;">
		<tr>
			<td width="200" height="50" align="center">
<!-- 				<a href="VM_Backend_GoodsList.html">商品列表</a> -->
				<a href="BackendServlet.do?action=queryGoods">商品列表</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="VM_Backend_GoodsReplenishment.html">商品維護作業</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="VM_Backend_GoodsCreate.html">商品新增上架</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="VM_Backend_GoodsSaleReport.html">銷售報表</a>
			</td>
		</tr>
	</table>
	<br/><br/><HR>
		
	<h2>銷售報表</h2><br/>
	<div style="margin-left:25px;">
	<form action="BackendServlet.do" method="get">
		<input type="hidden" name="action" value="querySalesReport"/>
		起 &nbsp; <input type="date" name="queryStartDate" style="height:25px;width:180px;font-size:16px;text-align:center;"/>
		&nbsp;
		迄 &nbsp; <input type="date" name="queryEndDate" style="height:25px;width:180px;font-size:16px;text-align:center;"/>	
		<input type="submit" value="查詢" style="margin-left:25px; width:50px;height:32px"/>
	</form>
	<br/>
	<table border="1">
		<tbody>
			<tr height="50">
				<td width="100"><b>訂單編號</b></td>
				<td width="100"><b>顧客姓名</b></td>
				<td width="100"><b>購買日期</b></td>
				<td width="125"><b>飲料名稱</b></td> 
				<td width="100"><b>購買單價</b></td>
				<td width="100"><b>購買數量</b></td>
				<td width="100"><b>購買金額</b></td>
			</tr>
			<tr height="30">
				<td>1</td>
				<td>Angela</td>
				<td>2018/09/08</td>
				<td>coke_original</td>
				<td>35</td> 
				<td>2</td>
				<td>70</td>	
			</tr>
			<tr height="30">
				<td>2</td>
				<td>Linda</td>
				<td>2018/02/13</td>
				<td>fanta_orange</td>
				<td>20</td> 
				<td>3</td>
				<td>60</td>	
			</tr>
			<tr height="30">
				<td>3</td>
				<td>Adam</td>
				<td>2018/05/05</td>
				<td>spring_original</td>
				<td>25</td> 
				<td>1</td>
				<td>25</td>	
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>