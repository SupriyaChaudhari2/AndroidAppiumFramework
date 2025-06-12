package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import SupriyaAssignment.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass extends AppiumUtils {
	
	public AndroidDriver driver ;
	
	public AppiumDriverLocalService service ;
	
	@BeforeClass
	
	public void configureAppium() throws URISyntaxException, IOException
	{
		
		Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream(("user.dir")+"//src//main//java//Resources//data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Resources/data.properties");

		prop.load(fis);
		String IPAddress = prop.getProperty("IPAddress");
		String port = prop.getProperty("port");
		
		
service = startAppiumServer(IPAddress, Integer.parseInt(port));
UiAutomator2Options options = new UiAutomator2Options();

// we need to tell appium the device name where we r going to run the test //
options.setDeviceName(prop.getProperty("AndroidDeviceName"));
options.setAppPackage("com.monefy.app.lite");
options.setAppActivity("com.monefy.activities.main.MainActivity_");



// Optional: avoid clearing app data every time
options.setNoReset(false);

driver = new AndroidDriver(service.getUrl(), options);

//driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// after java 20 URl class is depreciated so we need to use URI and then convert it to URL//

 

	}
	
	public void longpress(WebElement ele)
	{
		driver.executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		
	}
	
	@AfterClass
	
	public void teardown()
	{
		driver.quit();
		service.stop();
	}

}
