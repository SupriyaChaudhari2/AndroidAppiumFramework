package SupriyaAssignment.utils;

import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumUtils {
	public AppiumDriverLocalService service ;
	
	
	public AppiumDriverLocalService startAppiumServer(String IPAddress, int port)
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).withIPAddress(IPAddress).usingPort(port).build();
		service.start();
		return service;
	}
	
	

}
