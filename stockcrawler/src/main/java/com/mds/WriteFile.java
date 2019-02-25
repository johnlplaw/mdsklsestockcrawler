package com.mds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The class for generating csv file of the data 
 */
public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void writeToCsv(ArrayList<KLSEData> datalist) {
		
		BufferedWriter writer = null;
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_hh24mmss");
			String dateStr = df.format(new Date());
		    writer = new BufferedWriter( new FileWriter( "C:/johnlaw/klse/crawlerResult"+dateStr+".csv"));
		    
		    String title = "thedate,comp_name,comp_code,open,high,low,lastDone,chg,chgPercent,vol,buy,sell";
		    
		    writer.write( title);
		    
		    for(KLSEData data : datalist) {
		    	String row = "\n\"" + data.getDate() + "\"," 
		    			+ "\"" + data.getCompCode() + "\"," 
		    			+ "\"" + data.getCompname() + "\"," 
		    			+ "\"" + data.getOpenTxt() + "\"," 
		    			+ "\"" + data.getHighTxt() + "\"," 
		    			+ "\"" + data.getLowTxt() + "\"," 
		    			+ "\"" + data.getLastDoneTxt() + "\"," 
		    			+ "\"" + data.getChgTxt() + "\"," 
		    			+ "\"" + data.getChgPercentTxt() + "\"," 
		    			+ "\"" + data.getVolTxt() + "\"," 
		    			+ "\"" + data.getBuyTxt() + "\"," 
		    			+ "\"" + data.getSellTxt() + "\"" ;
		    	writer.write(row);
		    }

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
		
	}

}
