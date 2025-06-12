package SupriyaAssignment.Android;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SupriyaAssignment.pageObjects.android.AddIncomePage;
import SupriyaAssignment.pageObjects.android.HomePage;
import SupriyaAssignment.pageObjects.android.SplashScreen;
import TestUtils.BaseClass;
import io.appium.java_client.AppiumBy;

import org.testng.Assert;

public class AddIncome extends BaseClass {
	

	@BeforeMethod
	
	 public void handleSplash() {
       SplashScreen splashscreen = new SplashScreen(driver);
       splashscreen.skipSplashScreens();
	}

   	@Test
   	
   	public void AddfirstIncome()
   	{
   		 HomePage homepage = new HomePage(driver);
   		 AddIncomePage addincomepage = new AddIncomePage(driver);
   			
   		 homepage.SelectIncomeButton(); 
   		 addincomepage.AddAmount("2000");
   		 double expected = Double.parseDouble("2000"); 
   	     addincomepage.AddText("Test Income");
   	     addincomepage.getCategoryIcon(1).click();
   	     String Amount = homepage.getIncomeAmount();
   	     Double actual = Double.parseDouble(homepage.getIncomeAmount().substring(1).replace(",", ""));
   	     AssertJUnit.assertEquals(actual,expected);
   	}
   	
   }
	



