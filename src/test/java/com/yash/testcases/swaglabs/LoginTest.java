package com.yash.testcases.swaglabs;

import com.yash.base.BaseTest;
//import com.yash.pageobject.swaglabs.LoginPage;
import com.yash.swaglabs.LoginPage;
import com.yash.utilities.DataProviders;
import com.yash.utilities.TestUtil;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class LoginTest extends BaseTest
{
	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp",description = "Login to Swags Labs Application", enabled = false)
	@Description("Test Description: Login test with valid and invalid credentials")
	public void loginTest(Hashtable<String, String> data)
	{
		try {
			log.info("In start of the loginTest()");

			if (!data.get("runmode").equals("Y")) {
				throw new SkipException("Skipping the case as the Run mode for data set is NO");
			}
			String screenshotName = "Img_" + new SimpleDateFormat("yyyyMMddHHmm'.jpg'").format(new Date());
			String appUrl = config.getProperty("appUrl");
			String username = data.get("username");
			String password = data.get("password");
			System.out.println("appUrl: " + appUrl);
			driver.get(appUrl);
			log.info("Test application URL is loaded!");
			log.info("Page title is: " + driver.getTitle());
			log.info("Username: " + username + " and password is: " + password);  //For debugging
			String expPageTitle = "Swag Labs", actPageTitle;
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(username, password);
			TestUtil.captureScreenshot(userDir + "/target/" + screenshotName);
			actPageTitle = driver.getTitle();
			Assert.assertEquals(actPageTitle, expPageTitle, "Login Test is not executed successfully!");
			log.info("In end of the loginTest()");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
