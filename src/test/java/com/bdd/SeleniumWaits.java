package com.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

    public static void main(String args[]) {
        System.setProperty("webdriver.gecko.driver", "C:\\Narasimha\\codebase\\automation\\bdd-cucumber-webdriver-demo\\src\\test\\resources\\driver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.softwaretestingmaterial.com");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.titleIs("Software Testing Material - A site for Software Testers"));
        driver.close();
    }
}
