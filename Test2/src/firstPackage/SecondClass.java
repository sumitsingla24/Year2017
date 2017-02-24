package firstPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import secondPackage.ReUsableFunctions;

public class SecondClass {

	By name = By.name("uid");
	
	@Test
	public  void method4() throws Exception {
				
		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("http://demo.guru99.com/V4/");
		ReUsableFunctions.enterTextValue(name, "Driver 4");
		Thread.sleep(2000);
		ReUsableFunctions.closeAllInstance();
       
	}
	    
	@Test
	public  void method5() throws Exception {
		
		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("http://demo.guru99.com/V4/");
		ReUsableFunctions.enterTextValue(name, "Driver 5");
		Thread.sleep(2000);
		ReUsableFunctions.closeAllInstance();
               
	}    
        
	@Test
    public void method6() throws Exception {
		ReUsableFunctions.initiateDriver("Chrome");
		ReUsableFunctions.launchWebsite("http://demo.guru99.com/V4/");
		ReUsableFunctions.enterTextValue(name, "Driver 6");
		Thread.sleep(2000);
		ReUsableFunctions.closeAllInstance();
    		
        }
}
