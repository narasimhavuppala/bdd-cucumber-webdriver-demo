package com.bdd.stepdefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bdd.util.TakeScreenShot;
import com.bdd.util.WebElementUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmiCalculatorStepDefs {

	
	WebDriver driver;
	WebElementUtil objUtil;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://emicalculator.net/");
		objUtil=new WebElementUtil(driver);

	}

	@After
	public void cleanUp() {
		driver.close();

	}

	@Given("Navigate to tab {string}")
	public void navigate_to_tab(String tabName) {

		WebElement we = driver
				.findElement(By.xpath("/html/body/div[1]/div/main/article/div[3]/div/div[1]/div[1]/ul/li[1]/a"));

		we.click();
		System.out.println("tabName=" + tabName);
	}

	@Given("Enter the loan Amount as {string}")
	public void enter_the_loan_Amount_as(String loanAmount) {

		WebElement we = driver.findElement(By.xpath("//*[@id=\"loanamount\"]"));		
		objUtil.setInput(we, loanAmount);	

	}

	@Given("Enter the loan ROI as  {double}")
	public void enter_the_loan_ROI_as(Double roi) {
		WebElement we = driver.findElement(By.xpath("//*[@id=\"loaninterest\"]\r\n" + ""));
		objUtil.setInput(we, roi.toString());
	}

	@Given("Enter the loan Tenure as {int}")
	public void enter_the_loan_Tenure_as(Integer loanTenure) {

		WebElement we = driver.findElement(By.xpath("//*[@id=\"loanterm\"]\r\n" + ""));
		objUtil.setInput(we, loanTenure.toString());
		we.sendKeys(Keys.TAB);
	}

	@Given("Select the loan Tenure type as  {string}")
	public void select_the_loan_Tenure_type_as(String loanTenureType) {

		WebElement we = driver.findElement(By.xpath("//*[@id=\"loanyears\"]\r\n" + ""));
		System.out.println("loanTenureType=" + loanTenureType);
	}

	@When("Calculate EMI")
	public void calculate_EMI() {

		System.out.println("Calculating");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("EMI Should be equal to {double}")
	public void emi_Should_be_equal_to(double emi) {

		WebElement we = driver.findElement(By.xpath("//*[@id=\"emiamount\"]/p/span\r\n" + ""));
		String aemi = we.getText().replace(",", "");
		
		
		assertEquals(emi, Double.parseDouble(aemi), 0);

		
		TakeScreenShot.captureScreenShot(driver, "emi");
	}

}
