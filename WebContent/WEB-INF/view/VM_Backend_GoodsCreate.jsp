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
		
	<h2>�ӫ~�s�W�W�[</h2><br/>
	<div style="margin-left:25px;">
	<form action="BackendAction.do?action=createGoods" enctype="multipart/form-data" method="post">
		<p>
			���ƦW�١G
			<input type="text" name="goodsName" size="10"/>
		</p>
		<p>
			�]�w����G 
			<input type="number" name="goodsPrice" size="5" value="0" min="0"/>
		</p>
		<p>
			��l�ƶq�G
			<input type="number" name="goodsQuantity" size="5" value="0" min="0" max="1000"/>
		</p>
		<p>
			�ӫ~�Ϥ��G
			<input type="file" name="goodsImage"/>
		</p>
		<p>
			�ӫ~���A�G
			<select name="status">
				<option value="1">�W�[</option>
				<option value="0">�U�[</option>				
			</select>
		</p>
		<p>
			<input type="submit" value="�e�X">
		</p>
	</form>
	</div>
</body>
</html>