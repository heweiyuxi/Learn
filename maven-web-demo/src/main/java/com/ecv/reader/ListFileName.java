package com.ecv.reader;

import java.io.File;

public class ListFileName {

	public static void listAllFileName(){
		String folderpath = "E:/PROJECT_Leeds/Trunk/AppSource/xpc-appcommon/code/src/docroot/css/redmond/images";
		String prefix = "\"css:redmond:images:";
		String subffix= "{resource(url: [dir:\"css/redmond/images\" ";
		String middle = ", file:\"";
		String middleEnd = "\"])}";
		File file = new File(folderpath); 
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++){
			File singelFile= files[i];
			if(!singelFile.isDirectory()){
				String fileName = singelFile.getName();
				String nameForId = fileName.replace(".", "-");
				nameForId = nameForId.replace("_", "-");
				System.out.println(prefix+ nameForId+"\""+subffix+middle+fileName+middleEnd);
			}
			
		}
	}
	public static void main(String[] args) {
		listAllFileName();
	}

}
