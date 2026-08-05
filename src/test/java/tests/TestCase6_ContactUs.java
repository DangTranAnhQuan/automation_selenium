package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

@Epic("Core Features")
@Feature("Contact Us")
public class TestCase6_ContactUs extends BaseTest {

    @Test(description = "Test Case 6: Contact Us Form")
    @Description("Xác minh người dùng có thể gửi form liên hệ thành công với tệp đính kèm")
    public void testContactUsForm() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickContactUs();

        // Step 5
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "Form 'Get In Touch' không hiển thị.");

        // Step 6
        contactUsPage.fillContactForm("Anh Quan", "dangquan1912@gmail.com", "Test Subject", "Test Message");

        // Step 7: Upload file
        contactUsPage.uploadFile("C:\\test.txt");

        // Step 8
        contactUsPage.clickSubmit();

        // Step 9
        contactUsPage.acceptAlert();

        // Step 10
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Thông báo 'Success...' không hiển thị.");

        // Step 11
        contactUsPage.clickHomeBtn();
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị sau khi nhấn nút Home.");
    }
}