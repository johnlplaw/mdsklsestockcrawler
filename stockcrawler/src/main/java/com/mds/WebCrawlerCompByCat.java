package com.mds;

import static io.webfolder.ui4j.api.browser.BrowserFactory.getWebKit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import io.webfolder.ui4j.api.dom.Element;

import io.webfolder.ui4j.api.browser.Page;

public class WebCrawlerCompByCat {

	/**
	 * Crawl company by Category
	 * 
	 * @param list
	 * @param c
	 */
	private void crawProcessCat(ArrayList<String> list, String c) {
		Page page = getWebKit().navigate("https://www.thestar.com.my/business/marketwatch/stock-list/?sector=" + c);
		Element body = page.getDocument().getBody();
		for (int i = 1; i <= 500; i++) {
			String selectorStr = i == 0 ? "#marketwatchtable > tbody > tr > td:nth-child(1) > a"
					: "#marketwatchtable > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a";

			Element elem = body.query(selectorStr);
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
	public ArrayList<String> readCompCategory() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("CategoryList.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Crawl all the company code by alphabet form A to Z
	 * 
	 * @return Company Code in Array list
	 */
	public ArrayList<String> getAllCompByCategory() {
		ArrayList<String> list = new ArrayList<String>();

		try {

			ArrayList<String> catCodeList = this.readCompCategory();
			for (String catCode : catCodeList) {
				crawProcessCat(list, catCode);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Main process for crawling Company Code by Category
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			WebCrawlerCompByCat webCrawlerCompByCat = new WebCrawlerCompByCat();
			ArrayList<String> catList = webCrawlerCompByCat.readCompCategory();
			for (String catCode : catList) {

				System.out.println(catCode);
				ArrayList<String> compList = new ArrayList<String>();
				webCrawlerCompByCat.crawProcessCat(compList, catCode);

				for (String compCode : compList) {
					System.out.println(compCode);
				}
				KLSEDBHandling klse = new KLSEDBHandling();
				klse.insertCompCat(compList, catCode);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
