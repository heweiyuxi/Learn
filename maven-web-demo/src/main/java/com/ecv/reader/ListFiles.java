package com.ecv.reader;

/*
 * Created on 2004-12-9
 * �һ�δ�����ĸ������������������ܣ����д�����class
 * ����Խ������е��ļ�������txt�ļ��У����ڽ����Ĳ��ң����ӡ������
 * ����Ϊ�˲���ĳ�������е��ļ���һ��һ�Ź���ȥ�ң���������Ĺ�����
 *  ��ȻҲ����ѡ��ĳ��Ŀ¼����¼��Ŀ¼�µ������ļ�����
 */
/**
 * @author Shi Weifeng
 * ListFiles���ܹ���Ŀ¼�µ������ļ���д����ָ�����ı��ļ��С�
 */
import java.io.*;
public class ListFiles {
 private static String listFileStr="E:\\PROJECT_Leeds\\Trunk\\AppSource\\xpc-rsv\\code\\src\\docroot\\js\\rsv\\img";
 public static void main(String[] args) {
  try
  {
   File saveFile=new File(args[1]);
   FileWriter fw=new FileWriter(saveFile);
   ListFiles lf=new ListFiles();
   lf.listFile(args[0]);
   fw.write(listFileStr);
   fw.close();
  }
  catch (ArrayIndexOutOfBoundsException ea)
  {
   //������ʾ
   System.out.println("Usage: ListFiles <source dir> <target file>");
   
  }
  catch (IOException e)
  {
   System.out.println("IO error!\r\n"+e.toString());
  }
 }
 public void listFile(String rp)
  {
  
   File file=new File(rp);
   File list[]=file.listFiles();
   for(int i=0;i<list.length;i++)
   {
    try
    {
     if (list[i].isDirectory())
     {
      new ListFiles().listFile(list[i].toString());
     }
     else 
     {
      listFileStr+=list[i].getAbsolutePath()+"\r\n";
      System.out.println(list[i].getAbsolutePath());
     }
    }
    catch (Exception ex)
    {
     listFileStr+="Access deny��"+list[i].getAbsolutePath()+"\r\n";
     System.out.println("Access deny��"+list[i].getAbsolutePath());
    }
   }
  }
}
