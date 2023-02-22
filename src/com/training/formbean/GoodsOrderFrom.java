package com.training.formbean;

import java.util.Arrays;

public class GoodsOrderFrom {
	
	private String[] goodsID;
	
	private String[] buyQuantity;
	
	private String customerID;
	
	private int inputMoney;

	public String[] getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String[] goodsID) {
		this.goodsID = goodsID;
	}

	public String[] getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(String[] buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public void setInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}
	
	@Override
	public String toString() {
		return "GoodsOrderFrom [goodsID=" + Arrays.toString(goodsID)
				+ ", buyQuantity=" + Arrays.toString(buyQuantity)
				+ ", customerID=" + customerID + ", inputMoney=" + inputMoney
				+ "]";
	}
}
