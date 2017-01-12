package secondPackage;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class ReUsableFunctions {

	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static WebElement wb;
	static SoftAssert softassert = new SoftAssert();
	
	
	public static WebDriver getDriver(){
		return driver;
		
	}
	
	public static void launchWebsite (String url){
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void initiateDriver (String browserName){
		
		switch (browserName) {
		case "FireFox":
			System.setProperty("webdriver.gecko.driver","C:\\Eclipse\\JarFiles\\geckodriver.exe");
			driver = new FirefoxDriver();
			driverWait = new WebDriverWait(driver,10);	
			break;
		
		case "IE":
			System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\JarFiles\\IEDriverServer.exe");
       	 	driver=new InternetExplorerDriver();
			try {
				driverWait = new WebDriverWait(driver,10);	
			} catch (Exception e) {
				System.out.println(e.toString());
			}
       	 	break;
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\JarFiles\\chromedriver.exe");
       	 	driver=new ChromeDriver();
			try {
				driverWait = new WebDriverWait(driver,10);	
			} catch (Exception e) {
				System.out.println(e.toString());
			}
       	 	break;
		
		default:
			System.setProperty("webdriver.gecko.driver","C:\\Eclipse\\JarFiles\\geckodriver.exe");
			driver = new FirefoxDriver();
			try {
				driverWait = new WebDriverWait(driver,10);	
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			break;
		}
	
		
	}
	
	
	public static void enterTextValue(By locator, String textValue) throws Exception {
			
		try {
			if (waitForPageLoad()){	
				Thread.sleep(3000);
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wb = driver.findElement(locator);
			softassert.assertEquals(true, wb.isDisplayed());
			wb.clear();
			wb.sendKeys(textValue);
			}
		
		} catch (NoSuchElementException e) {				//FindBy method cant find the element.
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			interrupt();
		
		} catch (TimeoutException e) {	
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			interrupt();			
				
		} catch (StaleElementReferenceException e) {		//This tells that element is no longer appearing on the DOM page.
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			interrupt();
			
		} catch (ElementNotVisibleException e) {			//Thrown to indicate that although an element is present on the DOM, it is not visible, and so is not able to be interacted with
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			interrupt();
		}
	}
	
	public static void clickWebElement(By locator){
		try {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wb = driver.findElement(locator);
			softassert.assertEquals(true, wb.isDisplayed());
			wb.click();	
		} catch (TimeoutException e) {	
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			
		} catch (NoSuchElementException e) {				//FindBy method cant find the element.
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			
		} catch (StaleElementReferenceException e) {		//This tells that element is no longer appearing on the DOM page.
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
			
		} catch (ElementNotVisibleException e) {			//Thrown to indicate that although an element is present on the DOM, it is not visible, and so is not able to be interacted with
			softassert.assertEquals(true, wb.isDisplayed());
			System.out.println(e.toString());
		}
		
	}

	public static void interrupt(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		System.out.print("Interrupt");  
		scanner.nextLine();
		
	}
	
	public static boolean waitForPageLoad() {
		
		driverWait = new WebDriverWait(driver,10);
		
	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return driverWait.until(jQueryLoad) && driverWait.until(jsLoad);
	}
	
	public static void closeAllInstance(){
	
		driver.close();
		driver.quit();
		
		
	}
}
