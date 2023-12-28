package Practice.Automation;

import static org.testng.Assert.assertTrue;

import org.apache.commons.collections.map.HashedMap;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.utill.CommonFunction;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Unit test for simple App.
 */
public class Logout extends BaseClass {
	@Test
	public void simpleTestClass() {
		String testCaseName = this.getClass().getSimpleName();

		try {
			HashedMap testData = CommonFunction.getTestData("testDataBrilliusApp.xlsx", "TS_01", "Logout");
			homePage = verifyPageLoad();
			CommonFunction.extendReportSaveScreen(testCaseName, driver);
			homePage.enterDetails(driver, testData, testCaseName);
			BrilliusLogPage brilliusLogPage = homePage.navigateToBrilliusLogPage(driver, testCaseName);
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(brilliusLogPage.verifyLogIn(driver, testData, testCaseName));
			homePage = brilliusLogPage.navigateToLoginPage(driver, testData, testCaseName);
			sa.assertTrue(homePage.validateNamePassword(driver, testData, testCaseName));
			sa.assertAll();
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
