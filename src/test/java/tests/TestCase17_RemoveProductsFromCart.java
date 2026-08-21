package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

@Epic("Cart")
@Feature("Remove Products")
public class TestCase17_RemoveProductsFromCart extends BaseTest {

    @Test(description = "Test Case 17: Remove Products From Cart")
    @Description("Xác minh người dùng có thể xóa sản phẩm đã thêm khỏi giỏ hàng thành công")
    public void testRemoveProductsFromCart() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ hiển thị thất bại");

        // Step 4
        homePage.addFirstProductToCart();

        // Step 5
        homePage.clickViewCartOnModal();

        // Step 6
        Assert.assertTrue(cartPage.isCartPageVisible(), "Trang giỏ hàng hiển thị thất bại");

        // Step 7
        cartPage.clickDeleteProduct();

        // Step 8
        Assert.assertTrue(cartPage.isProductRemoved(), "Sản phẩm chưa bị xóa khỏi giỏ hàng");
    }
}