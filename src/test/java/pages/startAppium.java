package pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;



public class startAppium {

	@Test
	public void AppiumTest() throws MalformedURLException
	{
		
		AppiumDriverLocalService appiumService;
		
	        // Set the path to the Node.js executable (change this to your Node.js installation path)
	        String nodeJSPath = "C:\\Program Files\\nodejs\\node.exe";

	        // Set the path to the Appium.js file (change this to your Appium installation path)
	        String appiumJSPath = "C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

	        // Build the Appium service
	        AppiumServiceBuilder builder = new AppiumServiceBuilder()
	            .withAppiumJS(new File(appiumJSPath))
	            .usingDriverExecutable(new File(nodeJSPath))
	            .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
	            .withLogFile(new File("appium.log"));

	        appiumService = builder.build();
	        appiumService.start();
	        System.out.println("Appium server started on port " + appiumService.getUrl().getPort());
	    
		
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("Supriya");
//		options.setApp("C://Users//Admin//eclipse-workspace//TobiUI//src//test//java//resources//ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator2");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Supriya");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		cap.setCapability("aap.package", "io.appium.android.apis");
		cap.setCapability("app.activity", "io.appium.android.apis.ApiDemos");
		cap.setCapability(MobileCapabilityType.NO_RESET, "True");
		cap.setCapability(MobileCapabilityType.FULL_RESET, "false");
		cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("autoAcceptAlerts", "true");
    	cap.setCapability(MobileCapabilityType.APP, "C://Users//Admin//eclipse-workspace//TobiUI//src//test//java//resources//ApiDemos-debug.apk");
		AppiumDriver driver = new AppiumDriver(new URL("http://192.168.0.107:4723"), cap);
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		
		
		driver.close();
		//service.stop();
		appiumService.stop();
        System.out.println("Appium server stopped");
	}

}
