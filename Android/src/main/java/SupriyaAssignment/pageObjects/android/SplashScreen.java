package SupriyaAssignment.pageObjects.android;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SupriyaAssignment.utils.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SplashScreen extends AndroidActions {
	private AppiumDriver driver;
	public SplashScreen(AndroidDriver driver)
	{
		super(driver) ; // It will call parent class constructor 
		this.driver = driver ; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	private final By splashContinueBtn1 = By.id("com.monefy.app.lite:id/buttonContinue");
    private final By splashContinueBtn2 = By.xpath("//android.widget.Button[@text='AMAZING']");
    private final By splashContinueBtn3 = By.xpath("//android.widget.Button[@text='YES, PLEASE!']");
    private final By splashContinueBtn4 = By.xpath("//android.widget.Button[@text='I’M READY']");
    private final By denyPermissionBtn  = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private final By closeOfferScreen   = By.id("com.monefy.app.lite:id/buttonClose");

  

    public void skipSplashScreens() {
     //   System.out.println("🔍 Checking and skipping splash screens if present...");
        System.out.println("🔍 Page source:\n" + driver.getPageSource());

        clickIfPresent(splashContinueBtn1);
        clickIfPresent(splashContinueBtn2);
        clickIfPresent(splashContinueBtn3);
        clickIfPresent(denyPermissionBtn);
        clickIfPresent(splashContinueBtn4);
        clickIfPresent(closeOfferScreen); // Showed in second launch onwards

        System.out.println("Splash screen handling complete.");
    }

    private void clickIfPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            if (element.isDisplayed()) {
                System.out.println("Clicking: " + locator.toString());
                element.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Skipped (not present): " + locator.toString());
        } catch (Exception ex) {
            System.out.println(" Error interacting with: " + locator.toString() + " - " + ex.getMessage());
        }
    }
}

	
	
	
/*	AndroidDriver driver ;
	
	public SplashScreen(AndroidDriver driver)
	{
		super(driver) ; // It will call parent class constructor 
		this.driver = driver ; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	////////Splash screen //
	
			@AndroidFindBy(id="com.monefy.app.lite:id/buttonContinue")
			private WebElement splashcontinuebutton;
			
			@AndroidFindBy(xpath= "//android.widget.Button[@text='AMAZING']")
			private WebElement splashcontinuebutton2 ; 
			
			@AndroidFindBy(xpath= "//android.widget.Button[@text='YES, PLEASE!']")
			private WebElement splashcontinuebutton3 ; 
			
			@AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
			private WebElement denypermission;
			
			@AndroidFindBy(xpath= "//android.widget.Button[@text='I’M READY']")
			private WebElement splashcontinuebutton4 ; 
			
			@AndroidFindBy(id="com.monefy.app.lite:id/buttonClose")
			private WebElement closeScreen; 
			
			
	/*	public void skipsplash() {
			    try {
			        if (isElementPresent(splashcontinuebutton)) {
			            splashcontinuebutton.click();
			        }
			        if (isElementPresent(splashcontinuebutton2)) {
			            splashcontinuebutton2.click();
			        }
			        if (isElementPresent(splashcontinuebutton3)) {
			            splashcontinuebutton3.click();
			        }
			        if (isElementPresent(denypermission)) {
			            denypermission.click();
			        }
			        if (isElementPresent(splashcontinuebutton4)) {
			            splashcontinuebutton4.click();
			        }
			        if (isElementPresent(closeScreen)) {
			            closeScreen.click();
			        }
			    } catch (Exception e) {
			        // Log if needed, but continue if splash screen is already gone
			    }
			}
			
			
			public void skipSplash() {
			    try {
			        // Keep checking for known splash or permission screens
			        if (isElementPresent(splashcontinuebutton)) {
			            splashcontinuebutton.click();
			        }

			        if (isElementPresent(splashcontinuebutton2)) {
			            splashcontinuebutton2.click();
			        }

			        if (isElementPresent(splashcontinuebutton3)) {
			            splashcontinuebutton3.click();
			        }

			        if (isElementPresent(denypermission)) {
			            denypermission.click();
			        }

			        if (isElementPresent(splashcontinuebutton4)) {
			            splashcontinuebutton4.click();
			        }

			        if (isElementPresent(closeScreen)) {
			            closeScreen.click();
			        }

			    } catch (Exception e) {
			        System.out.println("Splash screen skipped or not present. Exception: " + e.getMessage());
			    }
			}

			
			


			private boolean isElementPresent(WebElement element) {
			    try {
			        return element.isDisplayed();
			    } catch (NoSuchElementException | StaleElementReferenceException e) {
			        return false;
			    }
			}*/

	


