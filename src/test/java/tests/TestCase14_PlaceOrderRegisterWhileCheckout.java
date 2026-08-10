package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

@Epic("Checkout Flow")
@Feature("Place Order")
public class TestCase14_PlaceOrderRegisterWhileCheckout extends BaseTest {

    @Test(description = "Test Case 14: Place Order: Register while Checkout")
    @Description("Xác minh luồng mua hàng thành công khi người dùng tạo tài khoản mới trong quá trình thanh toán")
    public void testPlaceOrderRegisterWhileCheckout() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignupInfoPage signupInfoPage = new SignupInfoPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        String dynamicEmail = "dangquan" + System.currentTimeMillis() + "@gmail.com";

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4 and 5
        homePage.addFirstProductToCart();
        homePage.clickViewCartOnModal();

        // Step 6 and 7
        Assert.assertTrue(cartPage.isCartPageVisible(), "Trang giỏ hàng không hiển thị.");
        cartPage.clickProceedToCheckout();

        // Step 8
        cartPage.clickRegisterLoginOnModal();

        // Step 9 and 10
        loginPage.signupNewUser("Dang Quan", dynamicEmail);
        signupInfoPage.fillAccountInformation("123456", "19", "12", "2004");
        signupInfoPage.fillAddressDetails("Dang", "Quan", "", "123 Main St", "", "United States", "California", "Los Angeles", "90001", "1234567890");
        signupInfoPage.clickCreateAccount();
        Assert.assertTrue(signupInfoPage.verifyAccountCreatedAndContinue(), "Thông báo 'Account Created!' không hiển thị.");

        // Step 11
        Assert.assertTrue(homePage.isLoggedInUserVisible(), "Header 'Logged in as' không hiển thị.");

        // Step 12 and 13
        homePage.clickCart();
        cartPage.clickProceedToCheckout();

        // Step 14
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Thông tin địa chỉ không hiển thị.");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review Order không hiển thị.");

        // Step 15
        checkoutPage.enterCommentAndPlaceOrder("Vui lòng giao hàng vào buổi sáng.");

        // Step 16 and 17
        paymentPage.fillPaymentDetailsAndConfirm("Dang Quan", "1234567890123456", "123", "12", "2024");

        // Step 18
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully(), "Thông báo đặt hàng thành công không hiển thị.");

        // Step 19 and 20
        homePage.clickDeleteAccount();
        Assert.assertTrue(signupInfoPage.verifyAccountDeletedAndContinue(), "Thông báo 'Account Deleted!' không hiển thị.");
    }
}