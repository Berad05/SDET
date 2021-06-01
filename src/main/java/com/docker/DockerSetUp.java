package com.docker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;



public class DockerSetUp {
 
  public static void start_Docker() throws IOException, InterruptedException {
	  boolean flag=false;
	  try {
		File file=new File("output.txt");
		  file.delete();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Runtime run=Runtime.getRuntime();
	 run.exec("cmd /c start dockerUp.bat");
	 Thread.sleep(5000);
	 Calendar cal= Calendar.getInstance();
	 cal.add(Calendar.SECOND, 45);
	 long stopTime=cal.getTimeInMillis();  
	 
	 while(stopTime>System.currentTimeMillis())
	{
		 if(flag==true)
		 {
			 break;
		 }
		 BufferedReader buff=new BufferedReader(new FileReader("output.txt"));
		 Thread.sleep(5000);
		 String currentLine=buff.readLine();
		 while(currentLine!=null && !flag)
		 {
			 System.out.println(currentLine);
			  if(currentLine.contains("The node is registered to the hub and ready to use"))
			  {
				  System.out.println("Found Text");
				  flag=true;
				  break;
			  }
			  currentLine=buff.readLine();
		 }
		
		 buff.close();
		 Thread.sleep(5000);
		
		 run.exec("cmd /c start Scale.bat");
		 Thread.sleep(15000);
		 System.out.println("Yes");
		 Assert.assertTrue(flag, "Container not spinned Up");
		 
		 
		 
	}
	
	
  }
  public static void stop_Docker() throws IOException, InterruptedException {
	  boolean flag=false;
	 
	 Runtime run=Runtime.getRuntime();
	 run.exec("cmd /c start Stop.bat");
	 Thread.sleep(5000);
	 Calendar cal= Calendar.getInstance();
	 cal.add(Calendar.SECOND, 45);
	 long stopTime=cal.getTimeInMillis();  
	 System.out.println(stopTime);
	 System.out.println(System.currentTimeMillis());
	 while(stopTime>System.currentTimeMillis())
	{
		 if(flag==true)
		 {
			 break;
		 }
		 BufferedReader buff=new BufferedReader(new FileReader("output.txt"));
		 String currentLine=buff.readLine();
		 while(currentLine!=null && !flag)
		 {
			 System.out.println(currentLine);
			  if(currentLine.contains("selenium-hub exited with code 143"))
			  {
				  System.out.println("Found Text");
				  flag=true;
				  break;
			  }
			  currentLine=buff.readLine();
		 }
		
		 buff.close();
		
		 Assert.assertTrue(flag, "Container not shut down properly");
		 System.out.println("yes");
		 
		 
	}
	
	
  }
  }
  