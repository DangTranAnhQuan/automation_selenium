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
public class TestCase15_PlaceOrderRegisterBeforeCheckout extends BaseTest {

    @Test(description = "Test Case 15: Place Order: Register before Checkout")
    @Description("Xác minh luồng mua hàng thành công khi người dùng tạo tài khoản từ trước khi thêm sản phẩm và tiến hành thanh toán")
    public void testPlaceOrderRegisterBeforeCheckout() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignupInfoPage signupInfoPage = new SignupInfoPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        String dynamicEmail = "dangquan" + System.currentTimeMillis() + "@gmail.com";

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ hiển thị thất bại");

        // Step 4
        homePage.clickSignupLogin();

        // Step 5
        loginPage.signupNewUser("Dang Quan", dynamicEmail);
        signupInfoPage.fillAccountInformation("123456", "19", "12", "2004");
        signupInfoPage.fillAddressDetails("Dang", "Quan", "", "123 Main St", "", "United States", "California", "Los Angeles", "90001", "1234567890");
        signupInfoPage.clickCreateAccount();

        // Step 6
        Assert.assertTrue(signupInfoPage.verifyAccountCreatedAndContinue(), "Thông báo 'Account Created!' không hiển thị.");

        // Step 7
        Assert.assertTrue(homePage.isLoggedInUserVisible(), "Header 'Logged in as' không hiển thị.");

        // Step 8
        homePage.addFirstProductToCart();

        // Step 9
        homePage.clickViewCartOnModal();

        // Step 10
        Assert.assertTrue(cartPage.isCartPageVisible(), "Trang giỏ hàng không hiển thị.");

        // Step 11
        cartPage.clickProceedToCheckout();

        // Step 12
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Thông tin địa chỉ không hiển thị.");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review Order không hiển thị.");

        // Step 13
        checkoutPage.enterCommentAndPlaceOrder("Vui lòng giao hàng vào buổi sáng.");

        // Step 14 and 15
        paymentPage.fillPaymentDetailsAndConfirm("Dang Quan", "1234567890123456", "123", "12", "2024");

        // Step 16
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully(), "Thông báo đặt hàng thành công không hiển thị.");

        // Step 17 and 18
        homePage.clickDeleteAccount();
        Assert.assertTrue(signupInfoPage.verifyAccountDeletedAndContinue(), "Thông báo 'Account Deleted!' không hiển thị.");
    }
}