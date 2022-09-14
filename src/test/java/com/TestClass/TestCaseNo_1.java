package com.TestClass;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;


import com.baseClass.Base;
import com.pageClass.LoginPage;
import com.utilities.ExtendReport;

@Listeners(ExtendReport.class)
public class TestCaseNo_1 extends Base{
	
	
	@Test
	public void login() throws InterruptedException
	{
		driver.get(mainUrl);
		Thread.sleep(3000);
		LoginPage lp=new LoginPage(driver);
		lp.emailClear();
		lp.passwordClear();
		Thread.sleep(3000);
		lp.enterCred(mainUsername,mainUserpass);
		Thread.sleep(3000);
		lp.loginclick();
	}

}
