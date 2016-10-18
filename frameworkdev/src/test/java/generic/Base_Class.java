package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	public WebDriver driver=null;
	Logger log=null;
	
@BeforeMethod
public void launchBrowser(){
	System.setProperty("webdriver.chrome.driver",Utility.getValue("chromeDriverPath") );
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log = Logger.getLogger("devpinoyLogger");
	driver.get(Utility.getValue("testURL"));
	log.debug("Opening application URL");
	
}

@AfterMethod
public void tearDown(){
	driver.quit();
}

public void screenshots(String TC_id,String order){
	
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
	File file=new File("E:\\AA_SELENIUM_BASICS\\zz_eclipse_project\\frameworkdev\\src\\Screenshots"+TC_id+"_"+order+"screenshot.png");
	try {
		FileUtils.copyFile(screenshotAs, file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
