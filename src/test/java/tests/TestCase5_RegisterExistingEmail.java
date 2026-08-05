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
@Feature("Register User")
public class TestCase5_RegisterExistingEmail extends BaseTest {

    @Test(description = "Test Case 5: Register User with existing email")
    @Description("Xác minh hệ thống hiển thị thông báo lỗi khi người dùng cố gắng đăng ký bằng một email đã tồn tại")
    public void testRegisterWithExistingEmail() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickSignupLogin();

        // Step 5
        Assert.assertTrue(loginPage.isSignupHeaderVisible(), "Form 'New User Signup!' không hiển thị.");

        // Step 6 and 7
        loginPage.signupNewUser("Anh Quan", "dangquan1912@gmail.com");

        // Step 8
        Assert.assertTrue(loginPage.isSignupErrorVisible(), "Thông báo 'Email Address already exist!' không hiển thị.");
    }
}