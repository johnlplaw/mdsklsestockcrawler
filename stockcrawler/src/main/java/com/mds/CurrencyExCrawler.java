package com.mds;

import static io.webfolder.ui4j.api.browser.BrowserFactory.getWebKit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.webfolder.ui4j.api.dom.Element;

import io.webfolder.ui4j.api.browser.Page;

public class CurrencyExCrawler {

	public ArrayList<CurrencyRateData> crawlProcess() {
		
		ArrayList<CurrencyRateData> list = new ArrayList<CurrencyRateData> ();
		Page page = getWebKit().navigate("http://www.bnm.gov.my/?tpl=exchangerates");
		Element body = page.getDocument().getBody();
		
		
		Element elemDate = body.query("#Content1700 > tbody > tr:nth-child(1) > th:nth-child(2) > b");
		String date = elemDate.getText();
		
		Element elemTime = body.query("#Session1700");
		int time = elemTime.getSelect().getSelectedIndex();
		String selectVal = elemTime.getSelect().getOptions().get(time).getElement().getText().trim();
				
		System.out.println(date + ", " + selectVal);
		
		for (int i = 3; i <= 29; i++) {

			
			
			Element elem = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(1)");
			String currDesc = elem.getText();
			String currUnit = currDesc.split(" ")[0];
			String currName = currDesc.split(" ")[1];
			Element elem2 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
			String currCode = elem2.getText();
			Element elem3 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(3)");
			String currBuyingRate = elem3.getText();
			Element elem4 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(4)");
			String invCurrBuyingRate = elem4.getText();
			Element elem5 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(5)");
			String currSellingRate = elem5.getText();
			Element elem6 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(6)");
			String invCurrSelingRate = elem6.getText();
			Element elem7 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(7)");
			String currMiddleRate = elem7.getText();
			Element elem8 = body.query("#Content1700 > tbody > tr:nth-child(" + i + ") > td:nth-child(8)");
			String invCurrMiddleRate = elem8.getText();

			CurrencyRateData currencyRateData = new CurrencyRateData();
			
			currencyRateData.setThedate(date);
			currencyRateData.setThetime(selectVal);
			currencyRateData.setCurName(currName);
			currencyRateData.setCurrCode(currCode);
			currencyRateData.setUnit(currUnit);
			currencyRateData.setBuyingVal(currBuyingRate);
			currencyRateData.setInvBuyingVal(invCurrBuyingRate);
			currencyRateData.setSellingVal(currSellingRate);
			currencyRateData.setInvSellingVal(invCurrSelingRate);
			currencyRateData.setMiddleRate(currMiddleRate);
			currencyRateData.setInvMiddleRate(invCurrMiddleRate);
			
			System.out.println(currencyRateData.toString());
			list.add(currencyRateData);
		}
		
		return list;
	}

	public static void main(String[] args) {

		CurrencyExCrawler currencyExCrawler = new CurrencyExCrawler();
		ArrayList<CurrencyRateData> list = currencyExCrawler.crawlProcess();
		
		WriteFile fw = new WriteFile();
		fw.writeCurrencyToCsv(list);
		
		CurrencyRateDBHandling db = new CurrencyRateDBHandling();
		db.insertCompCat(list);
		return;
	}

}
