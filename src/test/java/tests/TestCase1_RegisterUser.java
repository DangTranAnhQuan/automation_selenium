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
@Feature("Register User")
public class TestCase1_RegisterUser extends BaseTest {

    @Test(description = "Test Case 1: Register User")
    @Description("Xác minh quá trình đăng ký người dùng mới thành công và xóa tài khoản sau đó")
    public void testRegisterUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignupInfoPage signupInfoPage = new SignupInfoPage(driver);

        String dynamicEmail = "dangquan" + System.currentTimeMillis() + "@gmail.com";
//        String dynamicEmail = "dangquan1912@gmail.com";


        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4 & 5
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isSignupHeaderVisible(), "Trang New User Signup! không hiển thị.");

        // Step 6 & 7
        loginPage.signupNewUser("AnhQuan", dynamicEmail);

        // Step 8
        Assert.assertTrue(signupInfoPage.isEnterAccountInfoHeaderVisible(), "Trang Enter Account Information không hiển thị.");

        // Step 9, 10, 11, 12, 13
        signupInfoPage.fillAccountInformation("123456", "19", "12", "2004");
        signupInfoPage.selectCheckboxes();
        signupInfoPage.fillAddressDetails("Anh", "Quan", "FPT", "123 Đường ABC", "456 Đường XYZ", "Canada", "Ontario", "Toronto", "123456", "0987654321");
        signupInfoPage.clickCreateAccount();

        // Step 14 & 15
        Assert.assertTrue(signupInfoPage.verifyAccountCreatedAndContinue(), "Trang Account Created! không hiển thị.");

        // Step 16
        Assert.assertTrue(homePage.isLoggedInUserVisible(), "Trang 'Logged in as' không hiển thị.");

        // Step 17
        homePage.clickDeleteAccount();

        // Step 18
        Assert.assertTrue(signupInfoPage.verifyAccountDeletedAndContinue(), "Thông báo 'Account Deleted!' không hiển thị.");
    }
}