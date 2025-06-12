package SupriyaAssignment.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SupriyaAssignment.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExpensePage extends AndroidActions{

 
	
AndroidDriver driver ;

public  ExpensePage(AndroidDriver driver)
{
	super(driver) ; // It will call parent class constructor 
	this.driver = driver ; 
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

@AndroidFindBy(id="com.monefy.app.lite:id/leftLinesImageView")
private WebElement ExpenseListButton;

@AndroidFindBy(xpath="//android.widget.ExpandableListView[@resource-id=\"com.monefy.app.lite:id/expandableListViewTransactions\"]/android.widget.LinearLayout")
private WebElement Chooseexpense; 

@AndroidFindBy(id="new UiSelector().text(\"Edit expense\")")
private WebElement EditeexpenceePage; 

@AndroidFindBy(id="com.monefy.app.lite:id/delete")
private WebElement deletebutton ; 

@AndroidFindBy(id="com.monefy.app.lite:id/transaction_group_header")
private WebElement selectexpense;

@AndroidFindBy(xpath="//android.widget.TextView[@text='Balance $0.00'])")
	private WebElement zerobalance;
		

public void OpenExpenseList()
{
	ExpenseListButton.click();
}

public void chooseexpense()
{
    selectexpense.click();
	Chooseexpense.click();
}

public void deleteexpense()
{
	//EditeexpenceePage.isDisplayed();
	deletebutton.click();  // Trigger the toast

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'Record was deleted')]")
	));

	System.out.println("Toast Message: " + toast.getText());

	

}

}
