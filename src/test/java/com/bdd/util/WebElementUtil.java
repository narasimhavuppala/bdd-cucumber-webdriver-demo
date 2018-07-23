package com.bdd.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtil {

	WebDriver driver;

	public WebElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	public void clearInput(WebElement we) {
		// we.clear();
		we.sendKeys(Keys.CONTROL, "A");
		we.sendKeys(Keys.CLEAR);

	}

	public void setInput(WebElement we, String value) {

		System.out.println("Tag Name=" + we.getAttribute("name") + " and Val;ue =" + value);
		this.clearInput(we);
		we.sendKeys(value);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		TakeScreenShot.captureScreenShot(driver, we.getAttribute("name"));

	}

}
