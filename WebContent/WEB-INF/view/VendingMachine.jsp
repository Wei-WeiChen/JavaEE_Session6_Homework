<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-tw">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>�c���</title>
	<style type="text/css">
		.page {
			display:inline-block;
			padding-left: 10px;
		}
	</style>
	<script type="text/javascript">

	</script>
</head>

<body align="center">
<table width="1000" height="400" align="center">
	<tr>
		<td colspan="2" align="right">
			<form action="FrontendServlet.do" method="get">
				<input type="hidden" name="action" value="searchGoods"/>
				<input type="hidden" name="pageNo" value="1"/>
				<input type="text" name="searchKeyword"/>
				<input type="submit" value="�ӫ~�d��"/>
			</form>
		</td>
	</tr>
	<tr>
		<form action="FrontendServlet.do" method="post">
		<input type="hidden" name="customerID" value="A124243295"/>
		<td width="400" height="200" align="center">		
			<img border="0" src="DrinksImage/coffee.jpg" width="200" height="200" >			
			<h1>�w����{�ATomcat�I</h1>		
			<a href="VM_Backend_GoodsList.html" align="left" >��O����</a>&nbsp; &nbsp;
			<a href="#" align="left">�n�X</a>
			<br/><br/>
			<font face="�L�n������" size="4" >
				<b>��J:</b>
				<input type="number" name="inputMoney" max="100000" min="0"  size="5" value="0">
				<b>��</b>		
				<b><input type="submit" value="�e�X">					
				<br/><br/>
			</font>
			<div style="border-width:3px;border-style:dashed;border-color:#FFAC55;
				padding:5px;width:300px;">
				<p style="color: blue;">~~~~~~~ ���O���� ~~~~~~~</p>
				<p style="margin: 10px;">
					��J���B�G150
				</p>
				<p style="margin: 10px;">
					�ʶR���B�G111
				</p>
				<p style="margin: 10px;">
					��s���B�G39
				</p>
				<p style="margin: 10px;">
					fanta_grape 7 * 3
				</p>
				<p style="margin: 10px;">
					spring_original 20 * 2
				</p>
				<p style="margin: 10px;">
					pepsi_original 25 * 2
				</p>				
			</div>	
		</td>
		<td width="600" height="400">
			<input type="hidden" name="action" value="buyGoods"/>
			<table border="1" style="border-collapse: collapse">
				<tr>
					<td width="300">							
						<font face="�L�n������" size="5" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							���ܦʭ��A�G�� 
						</font>
						<br/>
						<font face="�L�n������" size="4" style="color: gray;" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							100 ��/��  
						</font>
						<br/>
						<!-- �U�ӫ~�Ϥ� -->
						<img border="0" src="DrinksImage/2020040717580083.jpg" width="150" height="150" >						
						<br/>
						<font face="�L�n������" size="3">
							<input type="hidden" name="goodsID" value="1">
							<!-- �]�w�̦h����R�j��w�s�ƶq -->
							�ʶR<input type="number" name="buyQuantity" min="0" max="30" size="5" value="0">��	
							<!-- ��ܮw�s�ƶq -->
							<br><p style="color: red;">(�w�s 0 ��)</p>
						</font>			
					</td>					
					<td width="300">							
						<font face="�L�n������" size="5" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							���ߪݼ��f�c�A�G�� 
						</font>
						<br/>
						<font face="�L�n������" size="4" style="color: gray;" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							7 ��/��  
						</font>
						<br/>
						<!-- �U�ӫ~�Ϥ� -->
						<img border="0" src="DrinksImage/20200407180213118.jpg" width="150" height="150">						
						<br/>
						<font face="�L�n������" size="3">
							<input type="hidden" name="goodsID" value="2">
							<!-- �]�w�̦h����R�j��w�s�ƶq -->
							�ʶR<input type="number" name="buyQuantity" min="0" max="30" size="5" value="0">��	
							<!-- ��ܮw�s�ƶq -->
							<br><p style="color: red;">(�w�s 0 ��)</p>
						</font>			
					</td>					
					<td width="300">						
					<font face="�L�n������" size="5" >
						<!-- �Ҧp: �i�f�i�� 30��/�� -->	
						�h���f�c���e��
					</font>
					<br/>
					<font face="�L�n������" size="4" style="color: gray;" >
						<!-- �Ҧp: �i�f�i�� 30��/�� -->	
						20 ��/��  
					</font>
					<br/>
					<!-- �U�ӫ~�Ϥ� -->
					<img border="0" src="DrinksImage/2021110210202761.jpg" width="150" height="150" >					
					<br/>
					<font face="�L�n������" size="3">
						<input type="hidden" name="goodsID" value="3">
						<!-- �]�w�̦h����R�j��w�s�ƶq -->
						�ʶR<input type="number" name="buyQuantity" min="0" max="30" size="5" value="0">��	
						<!-- ��ܮw�s�ƶq -->
						<br><p style="color: red;">(�w�s 0 ��)</p>
					</font>		
					</td>
				</tr>					
				<tr>
					<td width="300">							
						<font face="�L�n������" size="5" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							�h���
						</font>
						<br/>
						<font face="�L�n������" size="4" style="color: gray;" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							10 ��/��  
						</font>
						<br/>
						<!-- �U�ӫ~�Ϥ� -->
						<img border="0" src="DrinksImage/20190201101804603.jpg" width="150" height="150" >						
						<br/>
						<font face="�L�n������" size="3">
							<input type="hidden" name="goodsID" value="4">
							<!-- �]�w�̦h����R�j��w�s�ƶq -->
							�ʶR<input type="number" name="buyQuantity" min="0" max="30" size="5" value="0">��	
							<!-- ��ܮw�s�ƶq -->
							<br><p style="color: red;">(�w�s 0 ��)</p>
						</font>	
					</td>
					<td width="300">							
						<font face="�L�n������" size="5" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							������G��X�G��
						</font>
						<br/>
						<font face="�L�n������" size="4" style="color: gray;" >
							<!-- �Ҧp: �i�f�i�� 30��/�� -->	
							25 ��/��  
						</font>
						<br/>
						<!-- �U�ӫ~�Ϥ� -->
						<img border="0" src="DrinksImage/20190201104121279.jpg" width="150" height="150">						
						<br/>
						<font face="�L�n������" size="3">
							<input type="hidden" name="goodsID" value="5">
							<!-- �]�w�̦h����R�j��w�s�ƶq -->
							�ʶR<input type="number" name="buyQuantity" min="0" max="30" size="5" value="0">��	
							<!-- ��ܮw�s�ƶq -->
							<br><p style="color: red;">(�w�s 0 ��)</p>
						</font>	
					</td>						
					<td width="300">						
					<font face="�L�n������" size="5">
						<!-- �Ҧp: �i�f�i�� 30��/�� -->	
						�Ų��u�涼
					</font>
					<br/>
					<font face="�L�n������" size="4" style="color: gray;" >
						<!-- �Ҧp: �i�f�i�� 30��/�� -->	
						25 ��/��  
					</font>
					<br/>				
					<!-- �U�ӫ~�Ϥ� -->
					<img border="0" src="DrinksImage/20180131121732511.jpg" width="150" height="150">					
					<br/>
					<font face="�L�n������" size="3">
						<input type="hidden" name="goodsID" value="6">
						<!-- �]�w�̦h����R�j��w�s�ƶq -->
						�ʶR<input type="number" name="buyQuantity" min="0" max="30" size="5" value="0">��	
						<!-- ��ܮw�s�ƶq -->
						<br><p style="color: red;">(�w�s 0 ��)</p>
					</font>
					</td>			
				</tr>			
			</table>
		</td>
		</form>			
	</tr>
	<tr>
		<td colspan="2" align="right">				
			<h3 class="page"> <a href="FrontendServlet.do?action=searchGoods&pageNo=1"> �W�@�� </a> </h3>
			<h3 class="page"> <a href="FrontendServlet.do?action=searchGoods&pageNo=1"> 1 </a> </h3>
			<h3 class="page"> <a href="FrontendServlet.do?action=searchGoods&pageNo=2"> 2 </a> </h3>
			<h3 class="page"> <a href="FrontendServlet.do?action=searchGoods&pageNo=3"> 3 </a> </h3>  
			<h3 class="page"> <a href="FrontendServlet.do?action=searchGoods&pageNo=4"> �U�@�� </a> </h3>
		</td>
	</tr>
</table>


</body>

</html>