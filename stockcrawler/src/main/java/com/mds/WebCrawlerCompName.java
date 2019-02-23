package com.mds;

import java.util.ArrayList;

import io.webfolder.ui4j.api.browser.Page;
import static io.webfolder.ui4j.api.browser.BrowserFactory.getWebKit;
import io.webfolder.ui4j.api.dom.Element;

public class WebCrawlerCompName {

	public static void main(String[] args) {
		
		WebCrawlerCompName crawlCompName = new WebCrawlerCompName();
		ArrayList<String> list = crawlCompName.getAllCompByAlphabet();
	}
	
	public ArrayList<String> getAllCompByAlphabet(){
		ArrayList<String> list = new ArrayList<String>();
		try {
			
			for(char c = 'A'; c <= 'Z'; ++c) {
				Page page = getWebKit().navigate("https://www.thestar.com.my/business/marketwatch/stock-list/?alphabet=" + c);
				Element body = page.getDocument().getBody();
				for (int i = 1; i <=500; i++ ) {
					Element elem = body.query("#marketwatchtable > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a");  //form[action*='pagetreesearch']
					if(elem == null) {
						break;
					}
					list.add(elem.getText().trim());
				}
			}
			
			for(String comp: list) {
				System.out.println(comp);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return list;
	}

}
