package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import TestSuiteBase.SuiteBase;

public class FlightFinderPage extends SuiteBase{
	
	private static WebElement element = null;

	public static FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS)
			.pollingEvery(2, TimeUnit.SECONDS);

	// Passengers dropdown
	public static WebElement passengersDropdown() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='passCount']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}

	public static WebElement fromPort() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='fromPort']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement departMonth() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='fromMonth']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}

	public static WebElement departDay() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='fromDay']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement arrivalPort() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='toPort']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement returnMonth() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='toMonth']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement returnDay() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='toDay']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement prefClass() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='servClass']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement prefAirline() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='airline']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
	
	public static WebElement continueButton() {

		try {
			element = fwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@name='findFlights']")));
		} catch (Exception e) {
			throw(e);
		}
		return element;
	}
}
