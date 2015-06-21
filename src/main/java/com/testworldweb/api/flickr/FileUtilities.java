package com.testworldweb.api.flickr;

import java.io.*;
import java.util.Properties;

public class FileUtilities {
  public static String readFileText(String filename) throws IOException
  {
	  FileReader fileOne=null;
	  try {
		 fileOne =new FileReader(filename);
		
	} 
	  catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  BufferedReader buffer=new BufferedReader(fileOne);
	  String temp=buffer.readLine();
	  StringBuffer sb=new StringBuffer()
;	  
	  while(temp!=null){
		 sb.append(temp);
		 sb.append("\n");
		  // System.out.println(temp);
		  temp=buffer.readLine();
		  
		 
	  }
	  buffer.close();
	   return sb.toString();
  }
  public static void writeToFile(String fileName,String textToWrite) throws IOException
  {
	  FileWriter fw=new FileWriter(fileName);
	  fw.write(textToWrite);
	  fw.close();
	  
  }
  
  public  static String getConfigProperty(String config) throws IOException
  {
	 	Properties pr=new Properties();
	 	FileReader fr=new FileReader("config.properties");
	 	pr.load(fr);
	 	
	  return pr.getProperty(config);
  }
  public static void main(String[] args) throws IOException{
	  String result=readFileText("/Users/siuppal/Desktop/java1.txt");
	  System.out.println("RESULT is\n" +result);
	   result=readFileText("fileTest.txt");
	  System.out.println("RESULT is\n" +result);
      
	  writeToFile("fileWriten.txt","hello Ji");
	  
	  System.out.println("FirstName From config file is "+ getConfigProperty("middleName"));
	  
	  
	  

  
  }
}
