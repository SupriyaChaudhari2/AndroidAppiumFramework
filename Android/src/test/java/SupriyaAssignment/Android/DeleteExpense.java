package SupriyaAssignment.Android;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SupriyaAssignment.pageObjects.android.AddIncomePage;
import SupriyaAssignment.pageObjects.android.ExpensePage;
import SupriyaAssignment.pageObjects.android.HomePage;
import SupriyaAssignment.pageObjects.android.SplashScreen;
import TestUtils.BaseClass;

public class DeleteExpense extends BaseClass {
	
@BeforeMethod
	
	public void handleSplash() {
       
	SplashScreen splashscreen = new SplashScreen(driver);
	splashscreen.skipSplashScreens();
		
}

@Test

public void DeleteExpenses()
{
	HomePage homepage = new HomePage(driver);
	ExpensePage expensepage = new ExpensePage(driver);
	AddIncomePage addincomepage = new AddIncomePage(driver);
	
    System.out.println("App launched successfully!");
    homepage.SelectExpenseButton();
    addincomepage.AddAmount("300");
    double expected = Double.parseDouble("300"); 
    addincomepage.AddText("Test Expense");
    addincomepage.getCategoryIcon(1).click();
    String Amount =  homepage.getExpenseAmount();
    Double actual = Double.parseDouble(Amount.substring(1));
    AssertJUnit.assertEquals(actual, expected);
    expensepage.OpenExpenseList();
    expensepage.chooseexpense();
    expensepage.deleteexpense();
}

}
