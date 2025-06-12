package SupriyaAssignment.pageObjects.android;
 import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import SupriyaAssignment.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidActions {
	
	
		
AndroidDriver driver ;
		
		public HomePage(AndroidDriver driver)
		{
			super(driver) ; // It will call parent class constructor 
			this.driver = driver ; 
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}

		
		@AndroidFindBy(id="com.monefy.app.lite:id/expense_button")
		private WebElement expensebutton ;
		
		@AndroidFindBy(id="com.monefy.app.lite:id/amount_text")
		public WebElement AddExpenseAmount;
		
		
		@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/expense_amount_text\"]")
		private WebElement ExpenseAmount;
		
		@AndroidFindBy(id="com.monefy.app.lite:id/income_button")
		private WebElement AddIncomeButton;
		
		@AndroidFindBy(id="com.monefy.app.lite:id/income_amount_text")
		private WebElement IncomeAmount ;
		
		
		public String getExpenseAmount() {
			

		    return ExpenseAmount.getText();
		}

		
		
		public void SelectExpenseButton()
		{
			expensebutton.click();
		}
		
		
		public void SelectIncomeButton()
		{
			AddIncomeButton.click();
		}
		
		
		public String getIncomeAmount()
		
		{
			return IncomeAmount.getText();
		}
		

	}




