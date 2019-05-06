package scripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest {
	@Test
	public void testValidLogin() throws InterruptedException{
		//enter username - admin
		LoginPage login = new LoginPage(driver);
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		login.setUsername(username);
		//enter password - manager
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		login.setPassword(password);
		//click on Login 
		login.clickLogin();
		//Assert.fail();
		//Explicit wait example
		
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.titleIs("I dont know"));
		
		
		
		
		String aHomePageTitle = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aHomePageTitle, "I dont know..");
		sa.assertAll();
		//Assert.assertEquals(aHomePageTitle, "I dont know..");
		
		
		
		
		
		
		
		/*if (aHomePageTitle.equals("Wrong  page")) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Login failed..");
		}*/
	}
}
