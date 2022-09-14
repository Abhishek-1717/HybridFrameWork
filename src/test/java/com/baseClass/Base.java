package com.baseClass;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
  public WebDriver driver;
  
  ReadConfig read=new ReadConfig();
  
  public String mainUrl=read.BaseUrl();
  public String mainUsername=read.userName();
  public String mainUserpass=read.userPass();
  
  @Parameters({"browser"})
  @BeforeTest
  public void browserSet(@Optional("chrome")String browser) {
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
}
	else {
		throw new  RuntimeException("browser Value invalid");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}

  
  @AfterTest
  public void browserclose()
  {
	  driver.close();
  }
       
}

