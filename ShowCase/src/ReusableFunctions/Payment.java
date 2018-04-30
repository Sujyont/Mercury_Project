package ReusableFunctions;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.PaymentPage;
import TestSuiteBase.SuiteBase;

public class Payment extends SuiteBase {
	public static void paymentData(String passfirstName,String passlastName, String passengerMeal, 
			String creditcardType, String creditcardNumber, String cardexpiryMonth, String cardexpiryYear, 
			String cardFirstname, String cardMiddlename, String cardLastname) throws Exception {
		tempTest = extent.startTest("Payment Detail Page");
		try {
			
			sendkeys(PaymentPage.passfirstName(), "first name of passenger", passfirstName);
			sendkeys(PaymentPage.passlastName(), "last name of passenger", passlastName);
			dropDownValueSelect(PaymentPage.passengerMeal(), "Meal preference", passengerMeal);
			
			dropDownValueSelect(PaymentPage.creditcardType(), "Credit Card Type", creditcardType);
			sendkeys(PaymentPage.creditcardNumber(), "Credit Card Number", creditcardNumber);
			dropDownValueSelect(PaymentPage.cardexpiryMonth(), "Credit Card Expiry Month", cardexpiryMonth);
			dropDownValueSelect(PaymentPage.cardexpiryYear(), "Credit Card Expiry Year", cardexpiryYear);
			sendkeys(PaymentPage.cardFirstname(), "Credit Card Holder's first name", cardFirstname);
			sendkeys(PaymentPage.cardMiddlename(), "Credit Card Holder's middle name", cardMiddlename);
			sendkeys(PaymentPage.cardLastname(), "Credit Card Holder's last name", cardLastname);
			
			tempTest.log(LogStatus.PASS,  test.addScreenCapture(takeScreenShot()));
			click(PaymentPage.securePurchaseButton(), "secure Purchase Button");
			
			test.appendChild(tempTest);
		} catch (Exception e) {
			tempTest.log(LogStatus.FAIL,  e+test.addScreenCapture(takeScreenShot()));
			test.appendChild(tempTest);
			throw (e);
		}
	}

}
