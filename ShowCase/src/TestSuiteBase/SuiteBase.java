//*************************************************
/* Project: Demo Application
Author : Sujyonta Kumar Giri, Sr. Quality Analyst
Email: Sujyonta.Giri@Xceedance.com
Last Modified : 14-Nov-2017*/
//*************************************************
package TestSuiteBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Read_XLSX;

public class SuiteBase {	
	public static Read_XLSX TestSuiteListExcel=null;
	public static Read_XLSX TestCaseListCasualty=null;
	public static Read_XLSX TestCaseListEP=null;
	public static Read_XLSX TestCaseListMercury=null;
	public static Read_XLSX TestCaseListProperty=null;
	public static Logger Add_Log = null;
	public boolean BrowseralreadyLoaded=false;
	public static Properties Param = null;
	public static Properties status = null;
	static String screenShotPath = "";
	public static WebDriver driver=null;
	public static WebDriver ExistingchromeBrowser;
	public static WebDriver ExistingmozillaBrowser;
	public static WebDriver ExistingIEBrowser;
	
	protected static PrintWriter reporter = null;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest tempTest;
	
	
	public void init() throws IOException{
		
		//To Initialize logger service.
		String log4jConfigFile = System.getProperty("user.dir")+"//log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
        Add_Log = Logger.getLogger("rootLogger");
		//Please change file's path strings bellow If you have stored them at location other than bellow.
		//Initializing Test Suite List(TestSuiteList.xlsx) File Path Using Constructor Of Read_XLS Utility Class.
		TestSuiteListExcel = new Read_XLSX(System.getProperty("user.dir")+"\\ExcelFiles\\TestSuiteList.xlsx");
		//Initializing HealthCare Test Suite Two(HealthCare.xlsx) File Path Using Constructor Of Read_XLS Utility Class.
		TestCaseListMercury = new Read_XLSX(System.getProperty("user.dir")+"\\ExcelFiles\\MercuryTourTestData.xlsx");
		
		//Bellow given syntax will Insert log In applog.log file.
		Add_Log.info("All Excel Files Initialised successfully.");
		
		//Initialize Param.properties file.
		Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"//PropertiesFiles//Param.properties");
		Param.load(fip);
		Add_Log.info("Param.properties file loaded successfully.");	
		
	    
	     Add_Log.info("All Properties Files Initialised successfully.");
		
	}
	
	public void loadWebBrowser(){
		//Check If any previous webdriver browser Instance Is exist then run new test In that existing webdriver browser Instance.
			if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla") && ExistingmozillaBrowser!=null){
				driver = ExistingmozillaBrowser;
				return;
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("chrome") && ExistingchromeBrowser!=null){
				driver = ExistingchromeBrowser;
				return;
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE") && ExistingIEBrowser!=null){
				driver = ExistingIEBrowser;
				return;
			}		
		
		
			if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla")){
				//To Load Firefox driver Instance. 
				driver = new FirefoxDriver();
				ExistingmozillaBrowser=driver;
				Add_Log.info("Firefox Driver Instance loaded successfully.");
				
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("Chrome")){
				//To Load Chrome driver Instance.
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
				driver = new ChromeDriver();
				ExistingchromeBrowser=driver;
				Add_Log.info("Chrome Driver Instance loaded successfully.");
				
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE")){
				//To Load IE driver Instance.
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capabilities.setCapability("requireWindowFocus", true);
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//BrowserDrivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				ExistingIEBrowser=driver;
				Add_Log.info("IE Driver Instance loaded successfully.");
				
			}			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();			
	}
	
	public void closeWebBrowser(){
		driver.close();
		//null browser Instance when close.
		ExistingchromeBrowser=null;
		ExistingmozillaBrowser=null;
		ExistingIEBrowser=null;
	}
	//Method to check Complete Page To Load
	/*public static void checkPageIsReady() 
   {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		   for (int i=0; i<30; i++)
		  { 
		   	try 
			{
		    Thread.sleep(2000);
		    System.out.println("*******************-"+i);
		    }catch (InterruptedException e) {} 
		  
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
	}*/
	// Edited Time format used while saving screen shots
			public static String Time() {
				SimpleDateFormat NewDateformat = new SimpleDateFormat("dd-MM-yy HH:mm:ss:SSS");
				Date now = new Date();
				String Date = NewDateformat.format(now);
				return Date.replace(":", "-");
			}
	// For Taking screen shot
			public static String takeScreenShot() {
				try {
					File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					screenShotPath = System.getProperty("user.dir").concat("/Report/ScreenShots/") + Time().concat(".png");
					FileUtils.copyFile(source, new File(screenShotPath));
					 String base = System.getProperty("user.dir")+"/Report";
			          screenShotPath = new File(base).toURI().relativize(new File(screenShotPath).toURI()).getPath();
			           
				} catch (FileNotFoundException fnfe) {
					Add_Log.info("In takeScreenShot " + fnfe.getMessage());
					System.out.print("File not found" + fnfe);
				} catch (IOException e) {
					Add_Log.info("In takeScreenShot " + e.getMessage());
				} catch (Exception e) {
					Add_Log.info("In takeScreenShot " + e.getMessage());
				}
				return screenShotPath;
			}
			public static void initExtentReport(String TestCaseName)
			{
				//To initialize Extent report File
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyyh-mm-ss");
				String CurrentDate = sdf.format(date);
				extent = new ExtentReports(System.getProperty("user.dir")+"\\Report\\"+TestCaseName+CurrentDate+".html");
				//extent = new ExtentReports(System.getProperty("user.dir")+"\\Report\\"+TestCaseName+".html",false);
				extent.addSystemInfo("Selenium Version", "2.53.1");
				extent.addSystemInfo("Apache Poi Version", "3.15");
				extent.addSystemInfo("Environment", "Mercury Tours");
			}
			
			//For sendKeys Operation
				public static void sendkeys(WebElement element, String objectName, String objectValue) {
					try {
						
						highlightElement(element);
						element.click();
						element.clear();
						element.sendKeys(objectValue);
						element.sendKeys(Keys.TAB);
						tempTest.log(LogStatus.PASS, "Value Entered in "+objectName+" :: "+objectValue);
						Add_Log.info(objectName+"  Value Entered");
					}
					catch (Exception e) {
						tempTest.log(LogStatus.FAIL, "Failed to Entered value in "+objectName+e);
						Add_Log.info("Failed to enter value to  "  + objectName + e.getMessage());
						throw(e);
					}
				}
				//Drop down Operation
				public static void dropDownValueSelect(WebElement element, String objectName, String objectValue) {
					try {
						
						highlightElement(element);
						Select select = new Select(element);
						select.selectByVisibleText(objectValue);
						tempTest.log(LogStatus.PASS, "Value Selected in "+objectName+" DropDown :: "+objectValue);
						Add_Log.info(objectName+"  Value Selected");
					}
					catch (Exception e) {
						tempTest.log(LogStatus.FAIL, "Failed to Select value in "+objectName+e);
						Add_Log.info("Failed to Select value to  "  + objectName + e.getMessage());
						throw(e);
					}
				}	
				// For click of a web element
				public static void click(WebElement element, String objectName) {
					try {
						
						 highlightElement(element);
						 element.click();
						 tempTest.log(LogStatus.PASS, "Clicked on " + objectName);
						 Add_Log.info("Clicked on " + objectName);
					} catch (Exception e) {
						tempTest.log(LogStatus.FAIL, "Failed to click on " + objectName+e);
						Add_Log.info("In click " + e.getMessage());
						throw(e);
					}
				}
				// For click of a web element using JavascriptExecutor
				public static void clickJSE(WebElement element, String objectName) throws Exception {
					try {
						
						  JavascriptExecutor executor = (JavascriptExecutor) driver;
						 executor.executeScript("arguments[0].click();", element);
						 tempTest.log(LogStatus.PASS, "Clicked on " + objectName);
						 Add_Log.info("Clicked on " + objectName + " Element");
						 highlightElement(element);
						 
					} catch (Exception e) {
						tempTest.log(LogStatus.FAIL, "Failed to click on " + objectName + e);
						Add_Log.info("Failed to click on " + objectName + e.getMessage());
						throw(e);
					}
				}
				// For click of a web element By Actions Class
				public static void clickByActionsClass(WebElement element, String objectName) {
					try {
						
						 highlightElement(element);
						 Actions actions = new Actions(driver);
						 actions.moveToElement(element).click().build().perform();
						 tempTest.log(LogStatus.PASS, "Clicked on " + objectName);
						 Add_Log.info("Clicked on " + objectName);
					} catch (Exception e) {
						tempTest.log(LogStatus.FAIL, "Failed to click on " + objectName+e);
						Add_Log.info("In click " + e.getMessage());
						throw(e);
					}
				}
				
				
				//Highlighting the Element
				public static void highlightElement(WebElement element) 
				{  
					try {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 2px solid green;");  
					} catch (Exception e) {
						tempTest.log(LogStatus.FAIL, e.getMessage()+test.addScreenCapture(takeScreenShot()));
						throw(e);
					}
				} 
				// Switch to frame
				public static void switchToFrame(WebElement frame) {
					try {
						 highlightElement(frame);
						 driver.switchTo().frame(frame);
						 tempTest.log(LogStatus.PASS, "Switched to Frame");
						 Add_Log.info("Switched to Frame" );
					} catch (Exception e) {
						tempTest.log(LogStatus.FAIL, "Failed to switch to Frame  "+e);
						Add_Log.info("Failed to switch to Frame  " + e.getMessage());
						throw(e);
					}
				}
				
	
}
