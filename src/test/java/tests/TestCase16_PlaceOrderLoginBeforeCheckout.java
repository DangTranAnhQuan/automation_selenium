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
public class TestCase16_PlaceOrderLoginBeforeCheckout extends BaseTest {

    @Test(description = "Test Case 16: Place Order: Login before Checkout")
    @Description("Xác minh luồng mua hàng thành công khi người dùng đăng nhập bằng tài khoản có sẵn từ trước khi thêm sản phẩm và tiến hành thanh toán")
    public void testPlaceOrderLoginBeforeCheckout() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        SignupInfoPage signupInfoPage = new SignupInfoPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickSignupLogin();

        // Step 5
        loginPage.login("dangquan1912@gmail.com", "123456");

        // Step 6
        Assert.assertTrue(homePage.isLoggedInUserVisible(), "Đăng nhập không thành công.");

        // Step 7
        homePage.addFirstProductToCart();

        // Step 8
        homePage.clickViewCartOnModal();

        // Step 9
        Assert.assertTrue(cartPage.isCartPageVisible(), "Trang giỏ hàng không hiển thị.");

        // Step 10
        cartPage.clickProceedToCheckout();

        // Step 11
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Thông tin địa chỉ không hiển thị.");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Thông tin đơn hàng không hiển thị.");

        // Step 12
        checkoutPage.enterCommentAndPlaceOrder("Đây là ghi chú cho đơn hàng.");

        // Step 13 and 14
        paymentPage.fillPaymentDetailsAndConfirm("Dang Quan", "1234567890123456", "123", "12", "2024");

        // Step 15
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully(), "Thông báo đặt hàng không hiển thị.");

        // Step 16 and 17
        homePage.clickDeleteAccount();
        Assert.assertTrue(signupInfoPage.verifyAccountDeletedAndContinue(), "Thông báo xóa tài khoản không hiển thị.");
    }
}