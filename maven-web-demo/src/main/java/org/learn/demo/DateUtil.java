package org.learn.demo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YY_MM_DD = "yy-MM-dd";
	
	private static SimpleDateFormat format;
	public static String formatDate(Date date,String pattern){
		
		format = new SimpleDateFormat(pattern);
		String str = format.format(date);
		return str;
	}
	
	public static Date getCurrentDate(){
		return new  Timestamp(System.currentTimeMillis());
	}
	public static String formatDate(Object obj,String pattern){
		format = new SimpleDateFormat(pattern);
		String str = format.format(obj);
		return str;
		
	}
}
