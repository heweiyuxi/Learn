package com.green.he.base;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class TestGetDataSource {
	private static final Log logger  =LogFactory.getLog(TestGetDataSource.class);
	private static DataSource ds;
	private static String dsName = "java:jboss/datasources/XPCDataSource";
	
	static {  
        try {  
            Context ctx = new InitialContext();  
            ds = (DataSource)ctx.lookup(dsName);  
        } catch (NamingException e) {  
            logger.warn("Can not lookup the data source which named : " + dsName);  
            e.printStackTrace();  
        }  
    }  
	
	
	 public static Connection getConnection(){  
	        Connection conn = null;  
	        if(ds != null){  
	            try {  
	                conn = ds.getConnection();  
	            } catch (SQLException e) {  
	                logger.warn("Get Connection failed ...");  
	                e.printStackTrace();  
	            }  
	        }  
	        return conn;  
	    }  
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
