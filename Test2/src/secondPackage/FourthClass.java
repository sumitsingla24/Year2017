package secondPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FourthClass {

	By name = By.name("uid");
	
	@Test
    public void method7() throws Exception {
        	
		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("http://demo.guru99.com/V4/");
		ReUsableFunctions.enterTextValue(name, "Driver 7");
		Thread.sleep(2000);
		ReUsableFunctions.closeAllInstance();
        
        }
	
}