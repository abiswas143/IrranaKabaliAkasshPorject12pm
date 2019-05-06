package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstant{
	public WebDriver driver;
	static{
		//set the path of all three browser drivers execuables
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	@BeforeMethod
	public void openApplication(){
		//launch the browser
		driver = new FirefoxDriver();
		//enter the URL
		driver.get(Lib.getPropertyValue("URL"));
		//Set the implicit time period
		
		String timeout = Lib.getPropertyValue("IMPLICIT_TIMEOUT");
driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res){
		//capture screenshot for only the failed test script
		if (ITestResult.FAILURE==res.getStatus()) {
			Lib.captureScreenshot(driver, res.getName());
		}
		//close the browser
		driver.close();
	}
}
