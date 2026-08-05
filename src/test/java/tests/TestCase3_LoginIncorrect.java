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
@Feature("Login User")
public class TestCase3_LoginIncorrect extends BaseTest {

    @Test(description = "Test Case 3: Login User with incorrect email and password")
    @Description("Xác minh hệ thống hiển thị thông báo lỗi khi người dùng đăng nhập bằng email hoặc mật khẩu không hợp lệ")
    public void testLoginWithIncorrectCredentials() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickSignupLogin();

        // Step 5
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Form 'Login to your account' không hiển thị.");

        // Step 6 & 7
        loginPage.login("dangquan@gmail.com", "12345");

        // Step 8
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Thông báo lỗi không hiển thị.");
    }
}