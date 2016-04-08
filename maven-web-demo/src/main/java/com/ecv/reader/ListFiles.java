package com.ecv.reader;

/*
 * Created on 2004-12-9
 * 我还未发现哪个常用软件中有这个功能，因此写了这个class
 * 你可以将光盘中的文件名列在txt文件中，便于将来的查找，或打印出来。
 * 不用为了查找某个光盘中的文件而一张一张光盘去找，又慢又损耗光驱。
 *  当然也可以选择某个目录，记录下目录下的所有文件名。
 */
/**
 * @author Shi Weifeng
 * ListFiles类能够将目录下的所有文件名写入你指定的文本文件中。
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
   //参数提示
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
     listFileStr+="Access deny："+list[i].getAbsolutePath()+"\r\n";
     System.out.println("Access deny："+list[i].getAbsolutePath());
    }
   }
  }
}
