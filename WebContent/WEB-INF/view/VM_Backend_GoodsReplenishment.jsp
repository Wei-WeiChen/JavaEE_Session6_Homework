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
		
	<h2>�ӫ~���@�@�~</h2><br/>
	<div style="margin-left:25px;">
	<form action="BackendAction.do?action=updateGoods" method="post">
		<p>
			���ƦW�١G
			 <select name="goodsID">
				<option value="1">���ܦʭ��A�G��</option>
				<option value="2">���ߪݼ��f�c�A�G��</option>
				<option value="3">�h���f�c���e��</option>
				<option value="4">�h���</option>
				<option value="5">������G��X�G��</option>
				<option value="6">�Ų��u�涼</option>
				<option value="7">Cascara Macchiato</option>
				<option value="8">Iced Cascara</option>
				<option value="9">Dark Caramel Latte</option>
				<option value="10">White Chocolate Mocha</option>
				<option value="11">Flat White</option>
				<option value="12">Espresso Choice Extra Shot Latte</option>
				<option value="13">Cappuccino</option>
				<option value="14">Caffe Latte</option>
				<option value="15">Iced Caffe Latte</option>
				<option value="16">Caramel Macchiato</option>
				<option value="17">Iced Caramel Macchiato</option>
				<option value="18">Caffe Mocha</option>
				<option value="19">Iced Caffe Mocha</option>
				<option value="20">Caffe Americano</option>
				<option value="21">Iced Caffe Americano</option>
				<option value="22">Espresso</option>
				<option value="23">Triple Mocha Frappuccino</option>
				<option value="24">Dark Caramel Coffee Frappuccino</option>
				<option value="25">Coffee Frappuccino Blended Beverage</option>
				<option value="26">Caramel Frappuccino Blended Beverage</option>
				<option value="27">Caramel Java Chip Frappuccino Blended Beverage</option>
				<option value="28">Java Chip Frappuccino Blended Beverage</option>
			</select>
		</p>		
		<p>
			������G 
			<input type="number" name="goodsPrice" size="5" value="0" min="0" max="1000">
		</p>
		<p>
			�ɳf�ƶq�G
			<input type="number" name="goodsQuantity" size="5" value="0" min="0" max="1000">
		</p>
		<p>
			�ӫ~���A�G
			<select name="status">
				<option value="">---�п��---</option>
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