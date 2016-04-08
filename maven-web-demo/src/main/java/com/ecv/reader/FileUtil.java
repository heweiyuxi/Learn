package com.ecv.reader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class FileUtil {

	private static final Log logger = LogFactory.getLog(FileUtil.class);
	static final String filePath1 = "E:/20141014/RA-4.1-GA-B02/TestPRJ/src/com/ecv/resources/test.properties";
	public void copyFile(String target,String destination,String fileList) throws IOException{
		InputStream is =  new BufferedInputStream(new FileInputStream(fileList));
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		String value = null;
		System.out.println("===================Start to copy files================");
		//logger.debug("test");
		while((value=br.readLine())!=null){
			if(!StringUtil.isEmpty(value)){
				String fromFile = target+value.trim();
				String toFile = destination+value.trim();
				//copy(formFile, toFile);
				makeDirAndCopyFile(fromFile, toFile);
				
			}	
			
		}
	}
	
	private void makeDirAndCopyFile(String fromFile,String toFile){
		String [] str = toFile.split("/");
		String fileName = str[str.length-1];
		String filePath = toFile.replaceAll(fileName, "");		
		this.copy(fromFile,toFile,filePath);
	}
	
	private void copy(String from,String to,String toPath){
		File f = new File(from);
		File t = new File(toPath);
		//create directory
		if(!t.exists()){
			t.mkdirs();
		}
		t = new File(to);
		InputStream fis = null;
		OutputStream fos = null;
		if(!f.exists()){
			logger.info("File Not found ! =>"+ from);
		}
		try {
			fis = new BufferedInputStream(new FileInputStream(f));
			fos = new BufferedOutputStream(new FileOutputStream(t));
			byte[] buf = new byte[2048];
			int i;
				while((i=fis.read(buf))!=-1){
					fos.write(buf, 0, i);
				}
			logger.info("Copy File: "+from);
			//System.out.println("Copy File: "+from);	
		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println("File Not found ! =>"+ from );
			//logger.info("File Not found ! =>"+ from);
		}
		
	}
	
	
}
