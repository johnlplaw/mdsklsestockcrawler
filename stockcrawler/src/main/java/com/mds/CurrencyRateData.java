package com.mds;

public class CurrencyRateData {

	String thedate;
	String thetime;
	String curName;
	String currCode;
	String unit;
	String buyingVal;
	String invBuyingVal;
	String sellingVal;
	String invSellingVal;
	String middleRate;
	String invMiddleRate;
	
	public String getCurName() {
		return curName;
	}
	
	public String getThedate() {
		return thedate;
	}

	public void setThedate(String thedate) {
		this.thedate = thedate;
	}



	public String getThetime() {
		return thetime;
	}



	public void setThetime(String thetime) {
		this.thetime = thetime;
	}



	public void setCurName(String curName) {
		this.curName = curName;
	}
	public String getCurrCode() {
		return currCode;
	}
	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBuyingVal() {
		return buyingVal;
	}
	public void setBuyingVal(String buyingVal) {
		this.buyingVal = buyingVal;
	}
	public String getInvBuyingVal() {
		return invBuyingVal;
	}
	public void setInvBuyingVal(String invBuyingVal) {
		this.invBuyingVal = invBuyingVal;
	}
	public String getSellingVal() {
		return sellingVal;
	}
	public void setSellingVal(String sellingVal) {
		this.sellingVal = sellingVal;
	}
	public String getInvSellingVal() {
		return invSellingVal;
	}
	public void setInvSellingVal(String invSellingVal) {
		this.invSellingVal = invSellingVal;
	}
	public String getMiddleRate() {
		return middleRate;
	}
	public void setMiddleRate(String middleRate) {
		this.middleRate = middleRate;
	}
	public String getInvMiddleRate() {
		return invMiddleRate;
	}
	public void setInvMiddleRate(String invMiddleRate) {
		this.invMiddleRate = invMiddleRate;
	}
	
	public String toString() {
		return thedate + "," + thetime + "," + curName + "," + currCode + "," + unit + "," + buyingVal + "," 
				+ invBuyingVal + "," + sellingVal + "," + invSellingVal + "," + middleRate + "," + invMiddleRate;
		
	}
	
	
}
