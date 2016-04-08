package com.ecv.enu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DateFormat {

	private static final  Log logger   = LogFactory.getLog(DateFormat.class);
	public static void main(String[] args) {
		String path = "E:/test/test/test/test/test/etst";
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		try {
			File inFile = new File("E:\\Leeds3_40P4_20150112\\ProjectInstall\\Project-Release\\dataStorage\\PMIntegrationXMLFile\\PMIntegrationMsg_1423193128405.xml");
			File outFile = new File(path +"/1.txt");
			FileInputStream fis = new FileInputStream(inFile);
			FileOutputStream fos = new FileOutputStream(outFile);
			
			byte [] b = new byte[fis.available()];
			fis.read(b);
			fos.write(b);
			fis.close();
			fos.close();
			logger.info("Finsh write file!");
			
		} catch (Exception e) {
			logger.info(e);
		}
		
	}

}
