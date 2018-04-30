package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import TestSuiteBase.SuiteBase;

public class ItineraryDetailsPage extends SuiteBase{
	private static WebElement element = null;

	public static FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS)
			.pollingEvery(2, TimeUnit.SECONDS);
	
	public static WebElement flightConfirmationNo() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[contains(text(),'Confirmation')])[2]")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement departingDetails() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//tr[td[b[font[contains(text(),'Departing')]]]]/following-sibling::tr[1]/td/font")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement returningDetails() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//tr[td[b[font[contains(text(),'Returning')]]]]/following-sibling::tr[1]/td/font")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement billingDetails() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//tr[td[div[font[b[contains(text(),'Billed To')]]]]]/following-sibling::tr[1]/td/p")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement deliveryAddressDetails() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//tr[td[div[font[b[contains(text(),'Delivery Address')]]]]]/following-sibling::tr[1]/td/p")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement totalPriceIncludingTaxes() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[contains(text(),'USD')])[2]")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement signOff() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'SIGN-OFF/')]")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
}
