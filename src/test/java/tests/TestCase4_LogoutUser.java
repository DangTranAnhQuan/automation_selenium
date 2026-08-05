package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Epic("Authentication")
@Feature("Logout User")
public class TestCase4_LogoutUser extends BaseTest {

    @Test(description = "Test Case 4: Logout User")
    @Description("Xác minh người dùng có thể đăng xuất thành công và hệ thống điều hướng về lại trang đăng nhập")
    public void testLogoutUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

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
        homePage.ClickLogout();

        // Step 10
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Không quay về trang Login sau khi logout.");
    }
}