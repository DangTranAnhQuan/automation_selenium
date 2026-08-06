package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

@Epic("Navigation")
@Feature("Test Cases Page")
public class TestCase7_VerifyTestCasesPage extends BaseTest {

    @Test(description = "Test Case 7: Verify Test Cases Page")
    @Description("Xác minh người dùng có thể điều hướng từ trang chủ đến trang Test Cases thành công")
    public void testVerifyTestCasesPage() {
        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickTestCases();

        // Step 5
        Assert.assertTrue(testCasesPage.isTestCasesPageVisible(), "Trang 'Test Cases' không hiển thị.");
    }
}