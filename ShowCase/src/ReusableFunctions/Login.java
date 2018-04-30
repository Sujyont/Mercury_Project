package ReusableFunctions;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.LoginPage;
import TestSuiteBase.SuiteBase;

public class Login extends SuiteBase {
	public static void loginData(String userName,String password) throws Exception {
		tempTest = extent.startTest("Login Page");
		try {
			
			sendkeys(LoginPage.userName(), "UserName text box", userName);
			sendkeys(LoginPage.password(), "Password text box", password);
			tempTest.log(LogStatus.PASS,  test.addScreenCapture(takeScreenShot()));
			click(LoginPage.submitButton(), "submit Button");
			
			test.appendChild(tempTest);
		} catch (Exception e) {
			tempTest.log(LogStatus.FAIL,  e+test.addScreenCapture(takeScreenShot()));
			test.appendChild(tempTest);
			throw (e);
		}
	}
	
}
