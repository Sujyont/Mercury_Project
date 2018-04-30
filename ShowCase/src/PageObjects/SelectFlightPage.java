package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import TestSuiteBase.SuiteBase;

public class SelectFlightPage extends SuiteBase{
	
	private static WebElement element = null;

	public static FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS)
			.pollingEvery(2, TimeUnit.SECONDS);

	// Passengers dropdown
	public static WebElement departFlight() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='outFlight']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement returnFlight() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='inFlight']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement reserveFlights() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='reserveFlights']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}

}
