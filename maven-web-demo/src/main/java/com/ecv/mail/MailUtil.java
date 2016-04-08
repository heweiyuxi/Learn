package com.ecv.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

public class MailUtil {
	private static final Logger logger = Logger.getLogger(MailUtil.class);  
	  
    public boolean send(Mail mail) {  
        // ����email  
        HtmlEmail email = new HtmlEmail();  
        try {  
            // ������SMTP���ͷ����������֣�163�����£�"smtp.163.com"  
            email.setHostName(mail.getHost());  
            // �ַ����뼯������  
            email.setCharset(Mail.ENCODEING);  
            // �ռ��˵�����  
            email.addTo(mail.getReceiver());  
            // �����˵�����  
            email.setFrom(mail.getSender(), mail.getName());  
            // �����Ҫ��֤��Ϣ�Ļ���������֤���û���-���롣�ֱ�Ϊ���������ʼ��������ϵ�ע�����ƺ�����  
            email.setAuthentication(mail.getUsername(), mail.getPassword());  
            // Ҫ���͵��ʼ�����  
            email.setSubject(mail.getSubject());  
            // Ҫ���͵���Ϣ������ʹ����HtmlEmail���������ʼ�������ʹ��HTML��ǩ  
            email.setMsg(mail.getMessage());  
            // ����  
            email.send();  
            if (logger.isDebugEnabled()) {  
                logger.debug(mail.getSender() + " �����ʼ��� " + mail.getReceiver());  
            }  
            return true;  
        } catch (EmailException e) {  
            e.printStackTrace();  
            logger.info(mail.getSender() + " �����ʼ��� " + mail.getReceiver()  
                    + " ʧ��");  
            return false;  
        }  
    }  
    
    
    public static void main(String[] args) {  
       Mail mail = new Mail();  
        mail.setHost("smtp.163.com"); // �����ʼ�������,�������163��,�Լ����ҿ���ص�  
        mail.setSender("heweiyuxi@163.com");  
        mail.setReceiver("993202834@qq.com"); // ������  
        mail.setUsername("heweiyuxi@163.com"); // ��¼�˺�,һ�㶼�Ǻ�������һ����  
        mail.setPassword("1990919heyuming"); // ����������ĵ�¼����  
        mail.setSubject("aaaaaaaaa");  
       
    /*	String content = null;
        try {
			FileInputStream fis = new FileInputStream("E:/Green/LeedsConfig.xml");
//			File file = new File("E:/Green/LeedsConfig.xml");
			FileReader fr = new FileReader("E:/Green/LeedsConfig.xml");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while((line=br.readLine())!=null){
				content +=line;
			}
			br.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}        
        catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println(content);*/
        mail.setMessage("test send email");  
        new MailUtil().send(mail);  
    } 
  
}
