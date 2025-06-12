package SupriyaAssignment.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import SupriyaAssignment.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddIncomePage extends AndroidActions {
	
	AndroidDriver driver ;
	
	public  AddIncomePage(AndroidDriver driver)
	{
		super(driver) ; // It will call parent class constructor 
		this.driver = driver ; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id="com.monefy.app.lite:id/textViewNote")
	public WebElement text;

	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CHOOSE CATEGORY']")
	private WebElement chooseCategoryButton;
	
	
	
	@AndroidFindBy(id = "com.monefy.app.lite:id/imageView")
	private List<WebElement> categoryIcons;
	
    @AndroidFindBy(id="com.monefy.app.lite:id/amount_text")
    private WebElement amounttextbox;
	
	public void AddAmount(String amount)
	{
		
		    for (char digit : amount.toCharArray()) {
		        driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard" + digit)).click();
		       
		    
		}

	}

	
	public void AddText(String Text)
	{
		text.sendKeys(Text);
	}
	
	

    public WebElement getCategoryIcon(int index) {
    	
    	chooseCategoryButton.click();
    return categoryIcons.get(index); // Safe if you check index bounds

}
    
    public void chooseCategoryButton()
    {
    	chooseCategoryButton.click();
    }
    
    
    public void amounttextboxattribute()
    {
    	String focused = amounttextbox.getAttribute("focused");
    	System.out.println("Focused attribute: " + focused);
    	String selected = amounttextbox.getAttribute("selected");
    	String enabled = amounttextbox.getAttribute("enabled");
    	String contentDesc = amounttextbox.getAttribute("contentDescription"); // or "content-desc"
    	String classAttr = amounttextbox.getAttribute("class");

    	System.out.println("selected: " + selected);
    	System.out.println("enabled: " + enabled);
    	System.out.println("content-desc: " + contentDesc);
    	System.out.println("class: " + classAttr);
    }
}
