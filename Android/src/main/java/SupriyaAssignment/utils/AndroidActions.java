package SupriyaAssignment.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	
	AndroidDriver driver ; 
	
	public AndroidActions(AndroidDriver driver)
	{
		this.driver= driver ;
	}

	
	
	public WebElement waitForElement(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
}
