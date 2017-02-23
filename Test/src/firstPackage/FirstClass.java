package firstPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import secondPackage.ReUsableFunctions;

public class FirstClass {
	
	By username = By.xpath("//input[@id='Email']");
	By nextButton = By.xpath("//input[@id='next']");
	By password = By.xpath("//input[@id='Passwd']");
	By loginButton = By.xpath("//input[@id='signIn']");
	By name = By.name("uid");
    
	@Test
	public  void method1() throws Exception {

		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("https://www.google.com/mail");
		ReUsableFunctions.enterTextValue(username, "sumitsingla.24@gmail.com");
		ReUsableFunctions.clickWebElement(nextButton);
		ReUsableFunctions.enterTextValue(password, "1234");
		ReUsableFunctions.clickWebElement(loginButton);
		ReUsableFunctions.waitForPageLoad();
		ReUsableFunctions.closeAllInstance();
	}

	@Test
	public void method2() throws Exception {
		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("http://demo.guru99.com/V4/");
		ReUsableFunctions.enterTextValue(name, "Driver 2");
		Thread.sleep(3000);
		ReUsableFunctions.closeAllInstance();
	}    
        
	
	@Test
        public void method3() throws Exception {
		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("http://demo.guru99.com/V4/");
		ReUsableFunctions.enterTextValue(name, "Driver 3");
		Thread.sleep(2000);
		ReUsableFunctions.closeAllInstance();
	}




}
