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
        // 发送email  
        HtmlEmail email = new HtmlEmail();  
        try {  
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"  
            email.setHostName(mail.getHost());  
            // 字符编码集的设置  
            email.setCharset(Mail.ENCODEING);  
            // 收件人的邮箱  
            email.addTo(mail.getReceiver());  
            // 发送人的邮箱  
            email.setFrom(mail.getSender(), mail.getName());  
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码  
            email.setAuthentication(mail.getUsername(), mail.getPassword());  
            // 要发送的邮件主题  
            email.setSubject(mail.getSubject());  
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签  
            email.setMsg(mail.getMessage());  
            // 发送  
            email.send();  
            if (logger.isDebugEnabled()) {  
                logger.debug(mail.getSender() + " 发送邮件到 " + mail.getReceiver());  
            }  
            return true;  
        } catch (EmailException e) {  
            e.printStackTrace();  
            logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver()  
                    + " 失败");  
            return false;  
        }  
    }  
    
    
    public static void main(String[] args) {  
       Mail mail = new Mail();  
        mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
        mail.setSender("heweiyuxi@163.com");  
        mail.setReceiver("993202834@qq.com"); // 接收人  
        mail.setUsername("heweiyuxi@163.com"); // 登录账号,一般都是和邮箱名一样吧  
        mail.setPassword("1990919heyuming"); // 发件人邮箱的登录密码  
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
