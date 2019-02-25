package com.mds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import io.webfolder.ui4j.api.browser.Page;
import static io.webfolder.ui4j.api.browser.BrowserFactory.getWebKit;
import io.webfolder.ui4j.api.dom.Element;

/**
 * To handle the company code
 */
public class WebCrawlerCompName {

	/**
	 * The Main function for testing purpose
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		WebCrawlerCompName crawlCompName = new WebCrawlerCompName();
		ArrayList<String> list = crawlCompName.getAllCompByAlphabet();
		for (String a : list) {
			System.out.println(a);
		}
	}

	/**
	 * Crawl all the company code by alphabet form A to Z
	 * 
	 * @return Company Code in Array list
	 */
	public ArrayList<String> getAllCompByAlphabet() {
		ArrayList<String> list = new ArrayList<String>();
		try {

			for (char c = 'A'; c <= 'Z'; ++c) {
				crawProcess(list, String.valueOf(c));
			}

			crawProcess(list, "0-9");

			for (String comp : list) {
				System.out.println(comp);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	

	/**
	 * The main process for crawling company name
	 * 
	 * @param list
	 * @param c
	 */
	private void crawProcess(ArrayList<String> list, String c) {
		Page page = getWebKit().navigate("https://www.thestar.com.my/business/marketwatch/stock-list/?alphabet=" + c);
		Element body = page.getDocument().getBody();
		for (int i = 1; i <= 500; i++) {
			String selectorStr = i == 0 ? "#marketwatchtable > tbody > tr > td:nth-child(1) > a"
					: "#marketwatchtable > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a";

			Element elem = body.query(selectorStr); // form[action*='pagetreesearch']
			if (elem == null) {
				break;
			}
			list.add(elem.getText().trim());
		}
	}

	

	/**
	 * Read the company code from a text file
	 * 
	 * @return Company code in Array List
	 */
	public ArrayList<String> readCompCodeList() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("compCodeList.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
