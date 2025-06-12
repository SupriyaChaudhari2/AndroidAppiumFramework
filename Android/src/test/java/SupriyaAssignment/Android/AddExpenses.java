package SupriyaAssignment.Android;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import SupriyaAssignment.pageObjects.android.AddIncomePage;
import SupriyaAssignment.pageObjects.android.ExpensePage;
import SupriyaAssignment.pageObjects.android.HomePage;
import SupriyaAssignment.pageObjects.android.SplashScreen;
import TestUtils.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
public class AddExpenses extends BaseClass {

	@BeforeMethod
	
	public void handleSplash() {
       
  
SplashScreen splashscreen = new SplashScreen(driver);
splashscreen.skipSplashScreens();
	
	}
	
	@Test(dataProvider="getData")
    public void AddfirstExpense(String amount , String Note) {
		
		 HomePage homepage = new HomePage(driver);
		 AddIncomePage addincomepage = new AddIncomePage(driver);
		
         System.out.println("App launched successfully!");
         homepage.SelectExpenseButton();
         addincomepage.AddAmount(amount);
         double expected = Double.parseDouble(amount); 
         addincomepage.AddText(Note);
         addincomepage.getCategoryIcon(1).click();
         String Amount =  homepage.getExpenseAmount();
         Double actual = Double.parseDouble(Amount.substring(1));
         AssertJUnit.assertEquals(actual, expected);
	}
        
        
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"300","Test Expense"}};
	}

  }

