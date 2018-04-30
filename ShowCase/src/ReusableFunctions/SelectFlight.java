package ReusableFunctions;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.SelectFlightPage;
import TestSuiteBase.SuiteBase;

public class SelectFlight extends SuiteBase {
	public static void selectFlightData() throws Exception {
		tempTest = extent.startTest("Flight Selection Page");
		try {
			
			tempTest.log(LogStatus.PASS,  test.addScreenCapture(takeScreenShot()));
			click(SelectFlightPage.reserveFlights(), "Continue Button");
			
			test.appendChild(tempTest);
		} catch (Exception e) {
			tempTest.log(LogStatus.FAIL,  e+test.addScreenCapture(takeScreenShot()));
			test.appendChild(tempTest);
			throw (e);
		}
	}
	

}
