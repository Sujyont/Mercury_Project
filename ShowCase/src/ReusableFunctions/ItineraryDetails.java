package ReusableFunctions;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.ItineraryDetailsPage;
import TestSuiteBase.SuiteBase;

public class ItineraryDetails extends SuiteBase {
	public static void paymentData() throws Exception {
		tempTest = extent.startTest("=====Itinerary Details=====");
		try {
			
			tempTest.log(LogStatus.PASS, "<b><font color='22C80F'>Flight Confirmation #",ItineraryDetailsPage.flightConfirmationNo().getText());
			tempTest.log(LogStatus.PASS, "<b><font color='22C80F'>Departing Details : ", ItineraryDetailsPage.departingDetails().getText());
			tempTest.log(LogStatus.PASS, "<b><font color='22C80F'>Returning Details : ",ItineraryDetailsPage.returningDetails().getText());
			tempTest.log(LogStatus.PASS, "<b><font color='22C80F'>Billing Details : ",ItineraryDetailsPage.billingDetails().getText());
			tempTest.log(LogStatus.PASS, "<b><font color='22C80F'>Delivery Address Details : ",ItineraryDetailsPage.deliveryAddressDetails().getText());
			tempTest.log(LogStatus.PASS, "<b><font color='22C80F'>Total Price (including taxes) : ",ItineraryDetailsPage.totalPriceIncludingTaxes().getText());
			tempTest.log(LogStatus.PASS,  test.addScreenCapture(takeScreenShot()));
			
			click(ItineraryDetailsPage.signOff(), "Sign Off Link");Thread.sleep(3000);
			test.appendChild(tempTest);
		} catch (Exception e) {
			tempTest.log(LogStatus.FAIL,  e+test.addScreenCapture(takeScreenShot()));
			test.appendChild(tempTest);
			throw (e);
		}
	}


}
