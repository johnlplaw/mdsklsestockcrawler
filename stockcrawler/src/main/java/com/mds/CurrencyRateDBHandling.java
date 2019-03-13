package com.mds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CurrencyRateDBHandling {
	
	/**
	 * Insert the Company Category into  table in CompCat
	 * @param theList
	 */
	public void insertCompCat(ArrayList<CurrencyRateData> theList) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/mdsklse?"
                            + "user=root&password=root");

            String sqlStr = "INSERT INTO mdsklse.currex( " + 
            		"   thedate " + 
            		"  ,thetime " + 
            		"  ,curName " + 
            		"  ,currCode " + 
            		"  ,unit " + 
            		
            		"  ,buyingVal " + 
            		"  ,invBuyingVal " + 
            		"  ,sellingVal " + 
            		"  ,invSellingVal " + 
            		"  ,middleRate " + 
            		
            		"  ,invMiddleRate " + 
            		
            		") VALUES ( " + 
            		"   ?  -- thedate - IN varchar(50)\r\n" + 
            		"  ,?  -- thetime - IN varchar(50)\r\n" + 
            		"  ,?  -- curName - IN varchar(50)\r\n" + 
            		"  ,?  -- currCode - IN varchar(50)\r\n" + 
            		"  ,?  -- unit - IN varchar(50)\r\n" + 
            		"  ,?  -- buyingVal - IN varchar(50)\r\n" + 
            		"  ,?  -- invBuyingVal - IN varchar(50)\r\n" + 
            		"  ,?  -- sellingVal - IN varchar(50)\r\n" + 
            		"  ,?  -- invSellingVal - IN varchar(50)\r\n" + 
            		"  ,?  -- middleRate - IN varchar(50)\r\n" + 
            		"  ,?  -- invMiddleRate - IN varchar(50)\r\n" + 
            		") ";
            
            stmt = conn.prepareStatement(sqlStr);
            
            for(CurrencyRateData data : theList) {
            	stmt.setString(1, data.getThedate());
            	stmt.setString(2, data.getThetime());
            	stmt.setString(3, data.getCurName());
            	stmt.setString(4, data.getCurrCode());
            	stmt.setString(5, data.getUnit());
            	
            	stmt.setString(6, data.getBuyingVal());
            	stmt.setString(7, data.getInvBuyingVal());
            	stmt.setString(8, data.getSellingVal());
            	stmt.setString(9, data.getInvSellingVal());
            	stmt.setString(10, data.getMiddleRate());
            	
            	stmt.setString(11, data.getInvMiddleRate());
            	
            	
            	stmt.addBatch();             
            }
            
            stmt.executeBatch();
            
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
            
            
        }
	}
	
}
