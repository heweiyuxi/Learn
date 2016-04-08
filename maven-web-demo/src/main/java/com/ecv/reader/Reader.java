package com.ecv.reader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Reader {

	//static final String proFilePath = "/com/ecv/resources/test.properties"; 
	static final String proFilePath = "test.properties"; 
    static final String filePath1 = "E:/20141014/RA-4.1-GA-B02/TestPRJ/src/com/ecv/resources/test.properties";
    
	private static String target=null;
	private static String destination=null;
	private static String fileList=System.getProperty("user.dir") +"\\list.txt";
	private static String proprttiesFilePath = System.getProperty("user.dir") +"\\configuration.properties";
	 static {
		Properties properties = null;
		try {
			//properties = loadPropertiesFile2(proFilePath);
			properties = loadPropertiesFile(proprttiesFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		target = properties.getProperty("target");
		destination = properties.getProperty("destination");
		//fileList = properties.getProperty("fileList");
	}
	 
	/** 
     * 属性文件的相对路径 
     */  
    
	public static void main(String[] args) throws IOException {
				
		FileUtil fileUtil = new FileUtil();
		fileUtil.copyFile(target, destination, fileList);
	}

	private static Properties loadPropertiesFile(final String filePath) throws IOException{
		
		InputStream is =  new BufferedInputStream(new FileInputStream(filePath));
		Properties pro = new Properties();
		pro.load(is);
		return pro;
	}
	/**
	 * load properties file through absoulty path
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	private static Properties loadPropertiesFile2(final String filePath) throws IOException{
		final InputStream is = Properties.class.getResourceAsStream(filePath);
		Properties pro = new Properties();
		pro.load(is);
		return pro;
	}
	
	
	private static Properties getProperies() throws IOException{
		String filePath = System.getProperty("user.dir") +"\\configuration.properties";
		Properties properties = new Properties();
		  File file = new File("filePath");
		  FileInputStream fis = new FileInputStream(file);
		  properties.load(fis);
		  fis.close();
		  return properties;
	}
	
	
	
	
	/** 
     * 属性文件的绝对路径 
     */  
    final String absolutelyClasspath = "/com/hqsoft/test.properties";  
    /** 
     * 属性文件的相对路径 
     */  
    final String relativeClasspath = "com/hqsoft/test.properties";  
    /** 
     * 属性文件的屋里路径路径 
     */  
    final String filePath = "E:/works_eclipse/hqsoft/test/com/hqsoft/test.properties";  
	/** 
     * 使用java.util.Properties类的load()方法 
     *  
     * @param filePath 
     *            文件的物理路径 
     * @return 
     * @throws IOException 
     */  
    private static Properties load1ByAbsFilePath(final String filePath)  
            throws IOException {  
        final InputStream is = new BufferedInputStream(new FileInputStream(filePath));  
        final Properties properties = new Properties();  
        properties.load(is);  
  
        return properties;  
    }  
  
    /** 
     * 使用java.util.PropertyResourceBundle类的构造函数 
     *  
     * @param filePath 
     *            文件的物理路径 
     * @return 
     * @throws FileNotFoundException 
     * @throws IOException 
     */  
    private static ResourceBundle load2ByAbsFilePath(final String filePath)  
            throws FileNotFoundException, IOException {  
        final InputStream is = new BufferedInputStream(new FileInputStream(filePath));  
  
        return new PropertyResourceBundle(is);  
    }  
  
    /** 
     * 使用java.util.Properties.class变量的getResourceAsStream()方法 
     *  
     * @param absClasspath 
     *            classpath的绝对路径 
     * @return 
     * @throws IOException 
     */  
    private static Properties load3ByAbsClasspath(final String absClasspath)  
            throws IOException {  
        final InputStream is4 = Properties.class .getResourceAsStream(absClasspath);  
        final Properties p4 = new Properties();  
        p4.load(is4);  
          
        return p4;  
    }  
  
    /** 
     * 使用java.lang.ClassLoader类的getSystemResourceAsStream()静态方法 
     *  
     * @param relClasspath 
     *            class的相对路径 
     * @return 
     * @throws IOException 
     */  
    private static Properties load4ByRelClasspath(final String relClasspath)  
            throws IOException {  
        final InputStream is = ClassLoader.getSystemResourceAsStream(relClasspath);  
        final Properties properties = new Properties();  
        properties.load(is);  
  
        return properties;  
    }  
}
