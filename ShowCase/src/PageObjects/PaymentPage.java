package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import TestSuiteBase.SuiteBase;

public class PaymentPage extends SuiteBase{
	
	private static WebElement element = null;

	public static FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS)
			.pollingEvery(2, TimeUnit.SECONDS);

	// Passengers dropdown
	public static WebElement passfirstName() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='passFirst0']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement passlastName() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='passLast0']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}

	public static WebElement passengerMeal() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='pass.0.meal']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement creditcardType() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='creditCard']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement creditcardNumber() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='creditnumber']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement cardexpiryMonth() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='cc_exp_dt_mn']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement cardexpiryYear() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='cc_exp_dt_yr']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement cardFirstname() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='cc_frst_name']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}	
	
	public static WebElement cardMiddlename() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='cc_mid_name']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}	
	
	public static WebElement cardLastname() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='cc_last_name']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billingAddressCheckbox() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='ticketLess']")));//this needs to be made unique
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billAddress1() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='billAddress1']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billAddress2() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='billAddress2']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billCity() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='billCity']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billState() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='billState']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billZip() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='billZip']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement billCountry() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='billCountry']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement deliveryAddresscheckbox() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='ticketLess']")));//this needs to be made unique
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement delAddress1() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='delAddress1']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement delAddress2() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='delAddress2']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement delCity() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='delCity']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement delState() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='delState']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement delZip() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='delZip']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement delCountry() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='delCountry']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement securePurchaseButton() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='buyFlights']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
}
