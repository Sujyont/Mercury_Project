//*************************************************
/* Project: Demo Application
Author : Sujyonta Kumar Giri, Sr. Quality Analyst
Email: Sujyonta.Giri@Xceedance.com
Last Modified : 07-Feb-2017*/
//*************************************************
package MercuryTest;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ReusableFunctions.FlightFinder;
import ReusableFunctions.ItineraryDetails;
import ReusableFunctions.Login;
import ReusableFunctions.Payment;
import ReusableFunctions.SelectFlight;
import TestSuiteBase.SuiteUtility;
import Utility.Read_XLSX;



public class MercuryTour extends MercuryTourBase{
	Read_XLSX FilePath = null;	
	String SheetName = null;
	String TestCaseName = null;	
	String ToRunColumnNameTestCase = null;
	String ToRunColumnNameTestData = null;
	String TestDataToRun[]=null;
	static boolean TestCasePass=true;
	static int DataSet=-1;	
	static boolean Testskip=false;
	static boolean Testfail=false;
	SoftAssert s_assert =null;

	@BeforeTest
	public void checkCaseToRun() throws Exception{


		//Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		//To set TestCaseListMercury.xls file's path In FilePath Variable.
		FilePath = TestCaseListMercury;		
		TestCaseName = this.getClass().getSimpleName();	

		//SheetName to check CaseToRun flag against test case.
		SheetName = "TestCasesList";
		//Name of column In TestCasesList Excel sheet.
		ToRunColumnNameTestCase = "CaseToRun";
		//Name of column In Test Case Data sheets.
		ToRunColumnNameTestData = "DataToRun";

		//To check test case's CaseToRun = Y or N In related excel sheet.
		//If CaseToRun = N or blank, Test case will skip execution. Else It will be executed.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName,ToRunColumnNameTestCase,TestCaseName)){			
			//To report result as skip for test cases In TestCasesList sheet.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "SKIP");
			//To throw skip exception for this test case.
			throw new SkipException(TestCaseName+"'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+TestCaseName);
		}

		//To retrieve DataToRun flags of all data set lines from related test data sheet.
		TestDataToRun = SuiteUtility.checkToRunUtilityOfData(FilePath, TestCaseName, ToRunColumnNameTestData);

		initExtentReport(TestCaseName);

		loadWebBrowser();
		Add_Log.info("WebBrowser is instantiated");
		driver.get(Param.getProperty("ApplicationURL"));		

		test=extent.startTest("Mercury Tour");


	}

	//Accepts n column's String data In every Iteration.
	@Test(dataProvider="TestData")
	public void mercuryTour(String userName,String password,String passCount,String departPort, String departMonth, 
			String departDay,  String arrivePort, String returnMonth, String returnDay,
			String passfirstName,String passlastName, String passengerMeal, 
			String creditcardType, String creditcardNumber, String cardexpiryMonth, String cardexpiryYear, 
			String cardFirstname, String cardMiddlename, String cardLastname) throws Exception{

		DataSet++;

		//Created object of testng SoftAssert class.
		s_assert = new SoftAssert();		

		//If found DataToRun = "N" for data set then execution will be skipped for that data set.
		if(!TestDataToRun[DataSet].equalsIgnoreCase("Y")){
			//If DataToRun = "N", Set Testskip=true.
			Testskip=true;
			throw new SkipException("DataToRun for row number "+DataSet+" Is No Or Blank. So Skipping Its Execution.");
		}

		//If found DataToRun = "Y" for data set then bellow given lines will be executed.
		try
		{
			String myStr="Mercury";
//			Assert.assertEquals(driver.getTitle(), "Welcome:", "Google title mismatched");
			s_assert.assertEquals(driver.getTitle(), myStr);
			System.out.println("Move passed soft assert");
			
			
			Login.loginData(userName, password);
			
			String currentURL=driver.getCurrentUrl();
			s_assert.assertEquals(currentURL, "Logged in");

			FlightFinder.flightFinderData(passCount, departPort, departMonth, departDay, arrivePort, returnMonth, returnDay);

			SelectFlight.selectFlightData();

			Payment.paymentData(passfirstName, passlastName, passengerMeal, creditcardType, creditcardNumber, cardexpiryMonth, 
					cardexpiryYear, cardFirstname, cardMiddlename, cardLastname);

			ItineraryDetails.paymentData();
			s_assert.assertAll();
		}

		catch(Exception e)
		{
			Testfail=true;
			Add_Log.error(e);

		}


		extent.endTest(test);

	}	

	//@AfterMethod method will be executed after execution of @Test method every time.
	@AfterMethod
	public void reporterDataResults() throws Exception{		
		if(Testskip){
			//If found Testskip = true, Result will be reported as SKIP against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "SKIP");
		}
		else if(Testfail){
			System.out.println("Fail");
			//To make object reference null after reporting In report.
			s_assert = null;
			//Set TestCasePass = false to report test case as fail In excel sheet.
			TestCasePass=false;	
			//If found Testfail = true, Result will be reported as FAIL against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "FAIL");			
		}
		else{

			System.out.println("Pass");

			//If found Testskip = false and Testfail = false, Result will be reported as PASS against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "PASS");
		}
		//At last make both flags as false for next data set.
		Testskip=false;
		Testfail=false;


	}

	//This data provider method will return 4 column's data one by one In every Iteration.
	@DataProvider
	public Object[][] TestData(){
		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseTwo data Sheet.
		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
		return SuiteUtility.GetTestDataUtility(FilePath, TestCaseName);
	}

	//To report result as pass or fail for test cases In TestCasesList sheet.
	@AfterTest
	public void closeBrowser() throws Exception{
		extent.flush();
		closeWebBrowser();
		if(TestCasePass){
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "PASS");
		}
		else{
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "FAIL");
		}

	}
}