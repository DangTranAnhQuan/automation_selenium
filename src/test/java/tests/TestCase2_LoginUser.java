package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupInfoPage;

@Epic("Authentication")
@Feature("Login User")
public class TestCase2_LoginUser extends BaseTest {

    @Test(description = "Test Case 2: Login User with correct email and password")
    @Description("Xác minh người dùng có thể đăng nhập bằng email, password hợp lệ và xóa tài khoản sau đó")
    public void testLoginWithCorrectCredentials() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignupInfoPage signupInfoPage = new SignupInfoPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickSignupLogin();

        // Step 5
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Form 'Login to your account' không hiển thị.");

        // Step 6 and 7
        loginPage.login("dangquan1912@gmail.com", "123456");

        // Step 8
        Assert.assertTrue(homePage.isLoggedInUserVisible(), "Header 'Logged in as' không hiển thị.");

        // Step 9
        homePage.clickDeleteAccount();

        // Step 10
        Assert.assertTrue(signupInfoPage.verifyAccountDeletedAndContinue(), "Trang 'Account Deleted!' không hiển thị.");
    }
}