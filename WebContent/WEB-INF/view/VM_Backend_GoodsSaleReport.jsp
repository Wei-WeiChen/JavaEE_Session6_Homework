<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-tw">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>�c���-��O</title>
	<script type="text/javascript">

	</script>
</head>
<body>
	<h1>Vending Machine Backend Service</h1><br/>		
	<table border="1" style="border-collapse:collapse;;margin-left:25px;">
		<tr>
			<td width="200" height="50" align="center">
<!-- 				<a href="VM_Backend_GoodsList.html">�ӫ~�C��</a> -->
				<a href="BackendServlet.do?action=queryGoods">�ӫ~�C��</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="VM_Backend_GoodsReplenishment.html">�ӫ~���@�@�~</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="VM_Backend_GoodsCreate.html">�ӫ~�s�W�W�[</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="VM_Backend_GoodsSaleReport.html">�P�����</a>
			</td>
		</tr>
	</table>
	<br/><br/><HR>
		
	<h2>�P�����</h2><br/>
	<div style="margin-left:25px;">
	<form action="BackendServlet.do" method="get">
		<input type="hidden" name="action" value="querySalesReport"/>
		�_ &nbsp; <input type="date" name="queryStartDate" style="height:25px;width:180px;font-size:16px;text-align:center;"/>
		&nbsp;
		�� &nbsp; <input type="date" name="queryEndDate" style="height:25px;width:180px;font-size:16px;text-align:center;"/>	
		<input type="submit" value="�d��" style="margin-left:25px; width:50px;height:32px"/>
	</form>
	<br/>
	<table border="1">
		<tbody>
			<tr height="50">
				<td width="100"><b>�q��s��</b></td>
				<td width="100"><b>�U�ȩm�W</b></td>
				<td width="100"><b>�ʶR���</b></td>
				<td width="125"><b>���ƦW��</b></td> 
				<td width="100"><b>�ʶR���</b></td>
				<td width="100"><b>�ʶR�ƶq</b></td>
				<td width="100"><b>�ʶR���B</b></td>
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