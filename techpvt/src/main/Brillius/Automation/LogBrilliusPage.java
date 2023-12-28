package Brillius.Automation;

import java.text.SimpleDateFormat;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.project.utill.CommonFunction;
import com.project.utill.LoggingClass;
import com.relevantcodes.extentreports.LogStatus;

public class LogBrilliusPage {

	@FindBy(how = How.XPATH, using = "//input[@id='audioSession']")
	private WebElement Audio;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/input[1]")
	private WebElement Practice;

	@FindBy(how = How.ID, using = "//button[contains(text(),'Start Session')]")
	private WebElement Start Sessiont;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Video')]")
	private WebElement Video;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/label[1]")
	private WebElement Assessment;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Microphone')]")
	private WebElement Getearphone;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Start')]")
	private WebElement Start;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Feedback')]")
	private WebElement Get Feedback;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'>>')]")
	private WebElement Next;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Finish')]")
	private WebElement Finish;

	@FindBy(how = How.XPATH, using = "//div[@id='failFlashMsg']")
	private WebElement successMessage;

	public boolean validaterecordEnter(WebDriver driver, HashedMap testData, String testCaseName) {
		boolean result = false;
		try {
			String errormess = testData.get("TEXT_MESSAGE").toString();
			CommonFunction.clickButton(driver, btnSubmit, "Submit Button");
			CommonFunction.extendReportSaveScreen(testCaseName, driver);
			result = CommonFunction.verifyElementText(driver, successMessage, errormess);
		} catch (NullPointerException e) {
			BaseClass.test.log(LogStatus.WARNING, "Please check Test Data");
			LoggingClass.getLogger().info("Please check Test Data");
		}
		return result;
	}

	public void enterDetails(WebDriver driver, HashedMap testData, String testCaseName) {
		BaseClass.test.log(LogStatus.INFO, "**** Login Page Screen before Entering the Details ****");
		CommonFunction.extendReportSaveScreen(testCaseName, driver);
		try {
			String dateTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

			String dropdownValue = testData.get("PROMISE_FROM").toString();
			String BrilliusLog = testData.get("BRILLIUS_LOG").toString() + " Time: " + dateTimeStamp;
			testData.put("BRILLIUS_LOG", brilliusLog);
			CommonFunction.selectDropDown(driver, cboEmp, dropdownValue);
			txtPromise.sendKeys(brilliusLog);
			BaseClass.test.log(LogStatus.INFO, "**** Login Page Screen after Entering the Details ****");
			CommonFunction.extendReportSaveScreen(testCaseName, driver);
		}

		catch (NullPointerException e) {
			BaseClass.test.log(LogStatus.WARNING, "Please check Test Data");
			LoggingClass.getLogger().info("Please check Test Data");
		}
	}

	public BrilliusToPage naviageToBrilliusToPage(WebDriver driver, String testCaseName) {
		CommonFunction.clickButton(driver, btnSubmit, "Submit Button");
		PromiseToPage promiseToPage = PageFactory.initElements(driver, PromiseToPage.class);
		return promiseToPage;
	}

}
