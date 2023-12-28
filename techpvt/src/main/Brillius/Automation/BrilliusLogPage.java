package Practice.Automation;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.project.utill.CommonFunction;
import com.project.utill.LoggingClass;
import com.relevantcodes.extentreports.LogStatus;

public class BrilliusLogPage {

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	private WebElement username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement logpassword;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
	private WebElement login;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'User Management')]")
	private WebElement AddUser;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'User Management')]")
	private WebElement Userregistration;

	@FindBy(how = How.XPATH, using = "//input[@id='firstname']")
	private WebElement fname;
	
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']")
	private WebElement lname;
	
	@FindBy(how = How.XPATH, using = "//input[@id='email_address']")
	private WebElement Email;
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement cpassword;
	
	@FindBy(how = How.XPATH, using = "//input[@id='contactnumber']")
	private WebElement cnumber;
	
	@FindBy(Select rolelist = new Select(driver.findElement(By.id("usertype"))))
	rolelist.selectByVisibleText(role);
	private WebElement usertype;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Register')]")
	private WebElement Register;
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Back to Home')]")
	private WebElement backtohome;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Dashboard')]")
	private WebElement Dashboard;
	
	WebElement selectElement = driver.findElement(By.xpath("//option[contains(text(),'Select User')]"));
    Select dropdown = new Select(selectElement);
    dropdown.selectByVisibleText("Dravid");
	


	public LogBrilliusPage navigateToLogBrilliusPage(WebDriver driver, HashedMap testData, String testCaseName) {

		CommonFunction.clickButton(driver, logBrillius, "Log Brillius");
		LogPromisePage LogBrilliusPage = PageFactory.initElements(driver, LogBrilliusPage.class);
		return logBrilliusPage;
	}

	public LoginPage navigateToLoginPage(WebDriver driver, HashedMap testData, String testCaseName) {

		CommonFunction.clickButton(driver, logout, "Logout button");
		LoginPage logBrilliusPage = PageFactory.initElements(driver, LoginPage.class);
		return logBrilliusPage;
	}

	public boolean verifyLogIn(WebDriver driver, HashedMap testData, String testCaseName) {
		boolean result = false;
		CommonFunction.extendReportSaveScreen(testCaseName, driver);
		if (CommonFunction.verifyElement(driver, home) && CommonFunction.verifyElement(driver, logout)) {
			BaseClass.test.log(LogStatus.INFO, "**** Successfully Logged In ****");
			LoggingClass.getLogger().info("**** Successfully Logged In ****");
			result = true;
		} else {
			BaseClass.test.log(LogStatus.ERROR, "**** LogIn Failed ****");
			LoggingClass.getLogger().error("**** LogIn Failed ****");
		}
		return result;
	}

}
