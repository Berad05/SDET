package com.docker;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest3 {
	@BeforeSuite
	public void start_Docker() throws IOException, InterruptedException
	{
		DockerSetUp.start_Docker();
	}
	
	@AfterSuite
	public void stop_docker() throws IOException, InterruptedException
	{
		DockerSetUp.stop_Docker();
	}
  @Test
  public void validate_Google_Title() throws MalformedURLException {
	  DesiredCapabilities cap=DesiredCapabilities.chrome();
	  URL u=new URL("http://localhost:4444/wd/hub");
	  RemoteWebDriver driver=new RemoteWebDriver(u,cap);
	  driver.get("https://www.gmail.com");
	  System.out.println(driver.getTitle());
	  driver.close();
	  
  }
}
