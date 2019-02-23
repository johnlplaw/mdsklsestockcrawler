package com.mds;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebCrawlerKLSE {

	public static void main(String[] args) {
		
		try {
			WebCrawlerCompName crawlCompName = new WebCrawlerCompName();
			ArrayList<String> compName = crawlCompName.getAllCompByAlphabet();
			ArrayList<KLSEData> theresultList = new ArrayList<KLSEData>();
			
			//ArrayList<String> compName = new ArrayList<String>();
			//compName.add("D%26O");
			
			for (String compCode : compName) {
				
				compCode = escapeKey(compCode);
				// String compCode = "SAPNRG";
//				System.out.println(data.getDate());
//				System.out.println(data.getCompCode());
//				System.out.println(data.getCompname());
//				System.out.println(data.getOpenTxt());
//				System.out.println(data.getHighTxt());
//				System.out.println(data.getLowTxt());
//				System.out.println(data.getLastDoneTxt());
//				System.out.println(data.getChgTxt());
//				System.out.println(data.getChgPercentTxt());
//				System.out.println(data.getVolTxt());
//				System.out.println(data.getBuyTxt());
//				System.out.println(data.getSellTxt());
				
				try {
					Document doc = Jsoup
							.connect("https://www.thestar.com.my/business/marketwatch/stocks/?qcounter=" + compCode)
							.get();
					Element elm1 = doc.getElementById("slcontent_0_ileft_0_compnametxt");
					String field1 = elm1.text();
					Element elm2 = doc.getElementById("slcontent_0_ileft_0_opentext");
					String field2 = elm2.text();
					Element elm3 = doc.getElementById("slcontent_0_ileft_0_hightext");
					String field3 = elm3.text();
					Element elm4 = doc.getElementById("slcontent_0_ileft_0_lowtext");
					String field4 = elm4.text();
					Element elm5 = doc.getElementById("slcontent_0_ileft_0_lastdonetext");
					String field5 = elm5.text();
					Element elm6 = doc.getElementById("slcontent_0_ileft_0_chgtext");
					String field6 = elm6.text();
					Element elm7 = doc.getElementById("slcontent_0_ileft_0_chgpercenttrext");
					String field7 = elm7.text();
					Element elm8 = doc.getElementById("slcontent_0_ileft_0_voltext");
					String field8 = elm8.text();
					Element elm9 = doc.getElementById("slcontent_0_ileft_0_buyvol");
					String field9 = elm9.text();
					Element elm10 = doc.getElementById("slcontent_0_ileft_0_sellvol");
					String field10 = elm10.text();
					Element elm11 = doc.getElementById("slcontent_0_ileft_0_datetxt");
					String field11 = elm11.text().substring(10, 21);
					KLSEData data = new KLSEData(field11, field1, compCode, field2, field4, field3, field5, field6,
							field7, field8, field9, field10);
					theresultList.add(data);
				} catch (Exception e) {
					System.out.println("Error code: " + compCode );
					
				}

			}
			
			WriteFile wf = new WriteFile();
			wf.writeToCsv(theresultList);
			
			KLSEDBHandling klse = new KLSEDBHandling();
			klse.insertKLSEData(theresultList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	private static String escapeKey(String str) {
		return str.replace("&", "%26");
	}

}
