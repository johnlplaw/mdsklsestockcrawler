package com.mds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 * The class file for handling the mysql database transaction
 *
 */
public class KLSEDBHandling {

	public static void main(String[] args) {
		KLSEDBHandling klse = new KLSEDBHandling();
		
	}
	
	/**
	 * Insert the klsedata into KLSE table in mysql
	 * @param theList
	 */
	public void insertKLSEData(ArrayList<KLSEData> theList) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/mdsklse?"
                            + "user=root&password=root");

            String sqlStr = "INSERT INTO KLSE (thedate, " + 
            		"comp_name, " + 
            		"comp_code, " + 
            		"open, " + 
            		"low, " + 
            		"high, " + 
            		"lastDone, " + 
            		"chg, " + 
            		"chgPercent, " + 
            		"vol, " + 
            		"buy, " + 
            		"sell, crawl_Timestamp) values ("
            		+ "STR_TO_DATE(?, '%d %b %Y'), ?, ?, ?, ?, "
            		+ " ?, ?, ?, ?, ?, ?, ?, SYSDATE() )";
            
            stmt = conn.prepareStatement(sqlStr);
            
            for(KLSEData data : theList) {
            	stmt.setString(1, data.getDate());
            	stmt.setString(2, data.getCompname());
            	stmt.setString(3, data.getCompCode());
            	stmt.setString(4, data.getOpenTxt());
            	stmt.setString(5, data.getLowTxt());
            	stmt.setString(6, data.getHighTxt());
            	stmt.setString(7, data.getLastDoneTxt());
            	stmt.setString(8, data.getChgTxt());
            	stmt.setString(9, data.getChgPercentTxt());
            	stmt.setString(10, data.getVolTxt());
            	stmt.setString(11, data.getBuyTxt());
            	stmt.setString(12, data.getSellTxt());
                
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

	/**
	 * Insert the Company Category into  table in CompCat
	 * @param theList
	 */
	public void insertCompCat(ArrayList<String> theList, String CompCat) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/mdsklse?"
                            + "user=root&password=root");

            String sqlStr = "INSERT INTO CompCat ( " + 
            		"compCode, " + 
            		"Category, " + 
            		"Sub_category, " + 
            		"crawl_Timestamp) values ("
            		+ "?, ?, ?, SYSDATE() )";
            
            stmt = conn.prepareStatement(sqlStr);
            
            for(String compCode : theList) {
            	String[] catCodeArray = CompCat.split("_");
            	stmt.setString(1, compCode);
            	stmt.setString(2, catCodeArray[0]);
            	stmt.setString(3, catCodeArray[1]);
                
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
