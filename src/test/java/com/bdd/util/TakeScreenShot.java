package com.bdd.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class TakeScreenShot {
	
	public static void captureScreenShot(WebDriver driver,String fileName) {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File screenShot=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(screenShot, new File( "target/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
