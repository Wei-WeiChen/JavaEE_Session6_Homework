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
	<table border="1" style="border-collapse:collapse;margin-left:25px;">
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
		
	<h2>�ӫ~�C��</h2><br/>
	<div style="margin-left:25px;">
	<table border="1">
		<tbody>
			<tr height="50">
				<td width="150"><b>�ӫ~�W��</b></td> 
				<td width="100"><b>�ӫ~����</b></td>
				<td width="100"><b>�{���w�s</b></td>
				<td width="100"><b>�ӫ~���A</b></td>
			</tr>
			<tr height="30">
				<td>coke_original</td> 
				<td>100</td>
				<td>11</td>
				<td>�W�[</td>		
			</tr>		
			<tr height="30">
				<td>fanta_grape</td> 
				<td>7</td>
				<td>5</td>
				<td>�W�[</td>
			</tr>
			<tr height="30">
				<td>spring_original</td> 
				<td>20</td>
				<td>7</td>
				<td>�W�[</td>
			</tr>		
			<tr height="30">
				<td>coke_zero</td> 
				<td>10</td>
				<td>1</td>
				<td>�W�[</td>
			</tr>		
			<tr height="30">
				<td>pepsi_original</td> 
				<td>25</td>
				<td>4</td>
				<td>�W�[</td>
			</tr>
			<tr height="30">
				<td>fanta_orange</td> 
				<td>25</td>
				<td>0</td>
				<td>�W�[</td>
			</tr>	
		</tbody>
	</table>
	</div>
</body>
</html>