package com.ecv.readxml;

import java.io.*;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.*;

public class ReadXML {

	private static final String fileName = "E:/Leeds3_40P5_20150427/Leeds/project/template/BD/MM_PM_tpl.xml";
	private static final String vsFilePath = "E:/Leeds3_40P5_20150427/Leeds/project/template/VS";
	private static final String bdFilePath = "E:/Leeds3_40P5_20150427/Leeds/project/template/BD";
	
	
	public static void main(String[] args) {
		
		
		
		//Scan BD template
		getBDFile();
		
		
		//Scan VS template
		/*Map<String ,String > fieldCache = getFieldCache();
		printVSNeedChangeResult(fieldCache);*/
		
	}
	
	
	private static void printResult(File f){
		try {
			//File f = new File(fileName);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			List<Element> datas = doc.selectNodes("/OBJTPLS/formulas/target-field");
			List<Element> objectFields = doc.selectNodes("/OBJTPLS/OBJUITPLS/OBJFIELDUITPLS/OBJFIELDUITPL");
			List<String> targetField = new ArrayList<String>();
			Map<String,String>  map = new HashMap<String, String>();
			for (Element elm:datas){
				 Attribute attr1=  elm.attribute("ref-field-ui-id");
				 String value = attr1.getValue();
				 map.put(value, value);
				 //targetField.add(value);
				// System.out.println(value);
				 
			}
			for(Element elm:objectFields){
				 Attribute attr1=  elm.attribute("ID");
				 String value = attr1.getValue();
				 if(map.containsKey(value)){
					 Attribute attr2 = elm.attribute("editable");
					 String editAble = attr2.getValue();
					 if(editAble.equals("false")){
						 System.out.println("ID="+value +" editable="+ attr2.getValue());
						 getUIType( elm,value);
						 System.out.println();
					 }
					 
					/*List<Node> nodes = elm.selectNodes("/UITPLS/IU");
					 System.out.println(nodes.size());*/
				 }
				 //System.out.println(value);
			}
			 //getFile();
			//System.out.println("-------finished-----------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getFile(){
		File file = new File("E:/Leeds3_40P5_20150427/Leeds/project/template/BD");
		file.isDirectory();
		File [] files = file.listFiles();
		for(int i=0;i<files.length;i++){
			File f = files[i];
			String name = f.getName();
			System.out.println(name);			
			
			printResult(f);
		}
	}
	
	
	private static void getUIType(Element elm,String id){
		Iterator it = elm.elementIterator();
		while (it.hasNext()){
			Element element = (Element)it.next();
			String name = element.getName();
			if(name.equals("UITPLS")){
				Iterator it1 = element.elementIterator();
				System.out.println("ID= "+id);
				while(it1.hasNext()){					
					Element element1 = (Element)it1.next();
					Attribute mode = element1.attribute("mode");
					Attribute path = element1.attribute("path");
					//String name1 = element.getName();
//					if(path.getValue().equals("core/LABEL")||path.getValue().equals("core/INPUT")){						
						System.out.println("mode="+mode.getValue()+ " path="+path.getValue());
						
//					}
					
				}
				System.out.println();
			}
			//System.out.println(name);
		}
	}
	
	private static List<String>  fileNameList = new ArrayList<String>();
	private static List<String> getVSFile(String path){
		
		File file = new File(path);
		File [] files = file.listFiles();
		for(int i=0;i<files.length;i++){
			File f = files[i];
			if(f.isDirectory()){
				path =f.getPath();
				getVSFile(path);// 
			}
			String fileName = f.getName();
			if(fileName.endsWith(".xml")&&!f.isDirectory()){
				//System.out.println(f.getName());
				fileNameList.add(f.getPath());
			}
			
		}
		/*System.out.println(fileNameList);
		System.out.println(fileNameList.size());*/
		return fileNameList;
		
	}
	
	private static void readVSFile(File file ,Map<String,String> fieldCache){
		//File file = getVSFile(vsFilePath);
		if(file!=null){
			SAXReader reader = new SAXReader();
			try {
				Document doc = reader.read(file);
				List<Element> elements = doc.selectNodes("/view/result-fields/result-field");
				Element root = doc.getRootElement();
				Iterator it = root.elementIterator();
				while(it.hasNext()){
					Element view = (Element)it.next();
					String name = view.getName();
					if(name.equals("result-fields")){
						Iterator viewIt = view.elementIterator();
						while(viewIt.hasNext()){
							Element resuleFields = (Element)viewIt.next();
							Attribute attr = resuleFields.attribute("field-id");
							String idName = attr.getValue();
							
							Attribute attr2 = resuleFields.attribute("editable");
							if(fieldCache.containsKey(idName)){
								System.out.println("field-id="+idName+ " editable="+attr2.getValue());
							}
							/*String result = resuleFields.getName();
							System.out.println(result);*/
						}
					}
					
					
				}
				/*for(Element elm :elements){
					Attribute attr = elm.attribute("field-id");
					String idName = attr.getValue();
					
					Attribute attr2 = elm.attribute("editable");
					if(fieldCache.containsKey(idName)){
						System.out.println("field-id="+idName+ " editable="+attr2.getValue());
					}
				}*/
				
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private static Map<String,String> getFieldCache(){
		Map<String,String>  fieldCache = new HashMap<String, String>();
		
		File file = new File("E:/Leeds3_40P5_20150427/Leeds/project/template/BD");
		file.isDirectory();
		File [] files = file.listFiles();
		for(int i=0;i<files.length;i++){
			File f = files[i];
			
			try {
				//File f = new File(fileName);
				SAXReader reader = new SAXReader();
				Document doc = reader.read(f);
				List<Element> datas = doc.selectNodes("/OBJTPLS/formulas/target-field");
				List<Element> objectFields = doc.selectNodes("/OBJTPLS/OBJUITPLS/OBJFIELDUITPLS/OBJFIELDUITPL");
				List<String> targetField = new ArrayList<String>();
				Map<String,String>  map = new HashMap<String, String>();
				for (Element elm:datas){
					 Attribute attr1=  elm.attribute("ref-field-ui-id");
					 String value = attr1.getValue();
					 fieldCache.put(value, value);
					 //targetField.add(value);
					// System.out.println(value);
					 
				}
				for(Element elm:objectFields){
					 Attribute attr1=  elm.attribute("ID");
					 String value = attr1.getValue();
					 if(map.containsKey(value)){
						 Attribute attr2 = elm.attribute("editable");
						 String editAble = attr2.getValue();
						 if(editAble.equals("false")){
							 //System.out.println("ID="+value +" editable="+ attr2.getValue());
							// getUIType( elm);
							 //System.out.println();
//							 fieldCache.put(value, value);
						 }
						 
						/*List<Node> nodes = elm.selectNodes("/UITPLS/IU");
						 System.out.println(nodes.size());*/
					 }
					 //System.out.println(value);
				}
				 //getFile();
				//System.out.println("-------finished-----------");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		}
		return fieldCache;
	}
	
	
	private static File getBDFile(){
		File file = new File("E:/Leeds3_40P5_20150427/Leeds/project/template/BD");
		file.isDirectory();
		File [] files = file.listFiles();
		for(int i=0;i<files.length;i++){
			File f = files[i];
			String name = f.getName();
			System.out.println(name);			
			
			//printResult(f);
			printNumberFiels(f);
		}
		
		return null;
	}
	
	
	private static void printVSNeedChangeResult(Map<String ,String > fieldCache){
		List<String> fileList  =getVSFile(vsFilePath);
		for(String path:fileList){
			File file= new File(path);
			System.out.println(file.getName());			
			readVSFile(file, fieldCache);
			System.out.println();
		}
		
		
	}
	
	
	private static void printNumberFiels(File f){
		try {
			//File f = new File(fileName);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			List<Element> datas = doc.selectNodes("/OBJTPLS/OBJTYPES/OBJTYPE/FIELD");
			List<Element> objectFields = doc.selectNodes("/OBJTPLS/OBJUITPLS/OBJFIELDUITPLS/OBJFIELDUITPL");
			List<String> targetField = new ArrayList<String>();
			Map<String,String>  map = new HashMap<String, String>();
			for (Element elm:datas){
				 Attribute column=  elm.attribute("id");
				 Attribute type = elm.attribute("type");
				 if(type.getValue().equals("NUMBER")){
					 String value = column.getValue();
					 map.put(value, value);
				 }
				 
				 //targetField.add(value);
				// System.out.println(value);
				 
			}
			for(Element elm:objectFields){
				 Attribute attr1=  elm.attribute("ID");
				 Attribute attr2=  elm.attribute("viewable");
				 String viewable = attr2.getValue();
				 String value = attr1.getValue();
				 if(map.containsKey(value)&& viewable.equals("true")){
					
						 //System.out.println("ID="+value );
						 getUIType( elm,value);
//						 System.out.println();
					 
					
				 }
				 //System.out.println(value);
			}
			 //getFile();
			//System.out.println("-------finished-----------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}