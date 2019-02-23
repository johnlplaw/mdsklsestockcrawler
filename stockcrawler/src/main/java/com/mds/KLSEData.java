package com.mds;

public class KLSEData {

	String date;
	String compname;
	String compCode;
	String openTxt;
	String lowTxt;
	String highTxt;
	String lastDoneTxt;
	String chgTxt;
	String chgPercentTxt;
	String volTxt;
	String buyTxt;
	String sellTxt;

	public KLSEData(String date, String compname, String compCode, String openTxt, String lowTxt, String highTxt,
			String lastDoneTxt, String chgTxt, String chgPercentTxt, String volTxt, String buyTxt, String sellTxt) {
		this.date = date;
		this.compname = compname;
		this.compCode = compCode;
		this.openTxt = openTxt;
		this.lowTxt = lowTxt;
		this.highTxt = highTxt;
		this.lastDoneTxt = lastDoneTxt;
		this.chgTxt = chgTxt;
		this.chgPercentTxt = chgPercentTxt;
		this.volTxt = volTxt;
		this.buyTxt = buyTxt;
		this.sellTxt = sellTxt;

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getOpenTxt() {
		return openTxt;
	}

	public void setOpenTxt(String openTxt) {
		this.openTxt = openTxt;
	}

	public String getLowTxt() {
		return lowTxt;
	}

	public void setLowTxt(String lowTxt) {
		this.lowTxt = lowTxt;
	}

	public String getHighTxt() {
		return highTxt;
	}

	public void setHighTxt(String highTxt) {
		this.highTxt = highTxt;
	}

	public String getLastDoneTxt() {
		return lastDoneTxt;
	}

	public void setLastDoneTxt(String lastDoneTxt) {
		this.lastDoneTxt = lastDoneTxt;
	}

	public String getChgTxt() {
		return chgTxt;
	}

	public void setChgTxt(String chgTxt) {
		this.chgTxt = chgTxt;
	}

	public String getChgPercentTxt() {
		return chgPercentTxt;
	}

	public void setChgPercentTxt(String cgfPercentTxt) {
		this.chgPercentTxt = cgfPercentTxt;
	}

	public String getVolTxt() {
		return volTxt;
	}

	public void setVolTxt(String volTxt) {
		this.volTxt = volTxt;
	}

	public String getBuyTxt() {
		return buyTxt;
	}

	public void setBuyTxt(String buyTxt) {
		this.buyTxt = buyTxt;
	}

	public String getSellTxt() {
		return sellTxt;
	}

	public void setSellTxt(String sellTxt) {
		this.sellTxt = sellTxt;
	}

}
