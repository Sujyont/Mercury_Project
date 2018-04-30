package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import TestSuiteBase.SuiteBase;

public class LoginPage extends SuiteBase {
	private static WebElement element = null;

	public static FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS)
			.pollingEvery(2, TimeUnit.SECONDS);

	// UserName
	public static WebElement userName() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='userName']")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	// Password
	public static WebElement password() {

		try {
			element = fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	// Submit Button
		public static WebElement submitButton() {

			try {
				element = fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='login']")));
			} catch (Exception e) {
				throw (e);
			}
			return element;
		}
}
