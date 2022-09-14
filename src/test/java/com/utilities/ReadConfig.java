package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	String path=System.getProperty("user.dir")+"\\Configuration\\config.properties";
	
	Properties prop;
	
	public ReadConfig()
	{
		prop=new Properties();
	
		try {
			FileInputStream file=new FileInputStream(path);
			prop.load(file);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public String BaseUrl()
	{
		String url=prop.getProperty("url");
		return url;
	}
	
	public String setBrowser()
	{
		String Bvalue=prop.getProperty("browser");
		return Bvalue;
	}
	public String userName()
	{
		String Uname=prop.getProperty("userid");
		return Uname;
	}
	public String userPass()
	{
		String Upass=prop.getProperty("password");
		return Upass;
	}
}
