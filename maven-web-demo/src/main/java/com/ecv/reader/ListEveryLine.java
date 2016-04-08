package com.ecv.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListEveryLine {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		File file = new File("E:/PROJECT_Leeds/V3.8_20141210/wrm-upgrade-tool/log/potentialList.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr); 
		String str=null; 
		while((str=br.readLine())!=null) 
		{ 
			//boolean isJava =  str.contains(s)
			if(str!=null && str.contains(".js")&&!str.contains(".jsp")){
				System.out.println(str);
			}
			
		}
		Integer[] i=new Integer[list.size()];
		list.toArray(i);
	}

}
