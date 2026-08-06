package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

@Epic("Core Features")
@Feature("Subscription")
public class TestCase10_VerifySubscription extends BaseTest {

    @Test(description = "Test Case 10: Verify Subscription in home page")
    @Description("Xác minh người dùng có thể đăng ký nhận email bản tin thành công từ trang chủ")
    public void testVerifySubscriptionInHomePage() {
        HomePage homePage = new HomePage(driver);
        String emailToSubscribe = "dangquan1912@gmail.com";

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.scrollToFooter();

        // Step 5
        Assert.assertTrue(homePage.isSubscriptionHeaderVisible(), "Header 'SUBSCRIPTION' không hiển thị.");

        // Step 6
        homePage.subscribeToNewsletter(emailToSubscribe);

        // Step 7
        Assert.assertTrue(homePage.isSubscriptionSuccessMessageVisible(),
                "Thông báo 'You have been successfully subscribed!' không hiển thị.");
    }
}