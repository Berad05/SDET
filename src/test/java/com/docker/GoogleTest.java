package com.docker;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
  @Test
  public void validate_Google_Title() throws MalformedURLException {
	  DesiredCapabilities cap=DesiredCapabilities.chrome();
	  URL u=new URL("http://localhost:4444/wd/hub");
	  RemoteWebDriver driver=new RemoteWebDriver(u,cap);
	  driver.get("https://www.google.com");
	  System.out.println(driver.getTitle());
	  driver.close();
	  
  }
}
