package com.green.he.base;

/**
*ConnectionUtil .java
*
*
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties ;
public class ConnectionUtil {
 /**
  * 1
  *�ڷ����й̻����Ӳ���
  * @return  ���ݿ�����
  */
 public Connection getConnection(){
  Connection conn = null ;
  try{
   Class.forName("oracle.jdbc.driver.OracleDriver") ;

   conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.16.11:1521:ecv1db", "LEEDSUPGRADE", "LEEDSUPGRADE") ;

   return conn ;

  }catch(Exception e){
   e.printStackTrace() ;
  }
  return null ;
 }

 /**
  * 2
  *ͨ������������ʽ�������Ӳ���
  * @return  ���ݿ�����
  */
 public Connection getConnection(String driver, String url, String user, String password){

  Connection conn = null ;

  try{
   Class.forName(driver) ;
   conn = DriverManager.getConnection(url, user, password) ;

   return conn ;

  }catch(Exception e){
   e.printStackTrace();
  }

  return null ;
 }

 /**
  * 3
  *ͨ��properties�����ļ��ķ�ʽ����������Ӳ�����properties�е��������̻�
  * @return  ���ݿ�����
  */
 public Connection openConnection(){

  Connection conn = null ;
  String driver   = "" ;
  String url      = "" ;
  String user     = "" ;
  String password = "" ;
  Properties props = new Properties() ;
  try{
   props.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties")) ;
   driver   = props.getProperty("driver") ;
   url      = props.getProperty("url") ;
   user     = props.getProperty("user") ;
   password = props.getProperty("password") ;

   Class.forName(driver) ;
   conn = DriverManager.getConnection(url, user, password) ;

   return conn ;
  }catch(Exception e){
   e.printStackTrace() ;
  }

  return null ;
 }

 public static void main(String []args){
  ConnectionUtil cu = new ConnectionUtil() ;

  System.out.println("1��---->" + cu.getConnection()) ;
  System.out.println("2��---->" + cu.getConnection("com.mysql.jdbc.Driver",
    "jdbc:mysql://localhost:3306/stud", "root", "root")) ;
  System.out.println("3��---->" + cu.openConnection()) ;

 }

 
}