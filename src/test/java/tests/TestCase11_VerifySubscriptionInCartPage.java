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
public class TestCase11_VerifySubscriptionInCartPage extends BaseTest {

    @Test(description = "Test Case 11: Verify Subscription in Cart page")
    @Description("Xác minh người dùng có thể đăng ký nhận email bản tin thành công từ trang Giỏ hàng (Cart)")
    public void testVerifySubscriptionInCartPage() {
        HomePage homePage = new HomePage(driver);
        String emailToSubscribe = "dangquan1912@gmail.com";
        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickCart();

        // Step 5
        homePage.scrollToFooter();

        // Step 6
        Assert.assertTrue(homePage.isSubscriptionHeaderVisible(), "Phần SUBSCRIPTION không hiển thị.");

        // Step 7
        homePage.subscribeToNewsletter(emailToSubscribe);

        // Step 8
        Assert.assertTrue(homePage.isSubscriptionSuccessMessageVisible(),
                "Thông báo 'You have been successfully subscribed!' không hiển thị.");
    }
}