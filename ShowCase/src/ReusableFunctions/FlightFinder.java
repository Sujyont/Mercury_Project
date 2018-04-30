package ReusableFunctions;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.FlightFinderPage;
import TestSuiteBase.SuiteBase;

public class FlightFinder extends SuiteBase {
		public static void flightFinderData(String passCount,String departPort, String departMonth, 
				String departDay, String arrivePort, String returnMonth, String returnDay) throws Exception {
			tempTest = extent.startTest("Flight Finder Page");
			try {
				
				dropDownValueSelect(FlightFinderPage.passengersDropdown(), "Pasenger Count", passCount);
				dropDownValueSelect(FlightFinderPage.fromPort(), "Departing From", departPort);
				dropDownValueSelect(FlightFinderPage.departMonth(), "Onward Month of Journey: ", departMonth);
				dropDownValueSelect(FlightFinderPage.departDay(), "Onward Day of Journey: ", departDay);
				
				dropDownValueSelect(FlightFinderPage.arrivalPort(), "Port of Arrival: ", arrivePort);
				dropDownValueSelect(FlightFinderPage.returnMonth(), "Month of Return: ", returnMonth);
				dropDownValueSelect(FlightFinderPage.returnDay(), "Day of Return: ", returnDay);
				tempTest.log(LogStatus.PASS,  test.addScreenCapture(takeScreenShot()));
				click(FlightFinderPage.continueButton(), "continue Button");
				
				test.appendChild(tempTest);
			} catch (Exception e) {
				tempTest.log(LogStatus.FAIL,  e+test.addScreenCapture(takeScreenShot()));
				test.appendChild(tempTest);
				throw (e);
			}
		}

}
