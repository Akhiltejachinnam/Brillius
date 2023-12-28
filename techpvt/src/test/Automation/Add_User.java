package Practice.Automation;

import static org.testng.Assert.assertTrue;

import org.apache.commons.collections.map.HashedMap;
import org.testng.annotations.Test;

import com.project.utill.CommonFunction;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Unit test for simple App.
 */
public class Add_User extends BaseClass {
	@Test
	public void simpleTestClass() {
		String testCaseName = this.getClass().getSimpleName();

		try {
			HashedMap testData = CommonFunction.getTestData("testDataBrilliusApp.xlsx", "TS_01", "Add_User");
			homePage = verifyPageLoad();
			CommonFunction.extendReportSaveScreen(testCaseName, driver);
			homePage.enterDetails(driver, testData, testCaseName);
			BrilliusLogPage brilliusLogPage = homePage.navigateToBrilliusLogPage(driver, testCaseName);
			LogBrilliusPage logBrilliusPage = brilliusLogPage.navigateToLogBrilliusPage(driver, testData, testCaseName);
			logBrilliusPage.enterDetails(driver, testData, testCaseName);
			assertTrue(logbrilliusPage.validaterecordEnter(driver, testData, testCaseName));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			BaseClass.test.log(LogStatus.ERROR, e.getMessage());
			assertTrue(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			BaseClass.test.log(LogStatus.ERROR, e.getMessage());
			assertTrue(false);
		}
	}
}
