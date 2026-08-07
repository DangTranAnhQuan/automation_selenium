package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

@Epic("Cart")
@Feature("Add Products")
public class TestCase12_AddProductsInCart extends BaseTest {

    @Test(description = "Test Case 12: Add Products in Cart")
    @Description("Xác minh người dùng có thể thêm nhiều sản phẩm vào giỏ hàng và thông tin hiển thị chính xác")
    public void testAddProductsInCart() {
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickProducts();

        // Step 5
        productsPage.addFirstProductToCart();

        // Step 6
        productsPage.clickContinueShopping();

        // Step 7
        productsPage.addSecondProductToCart();

        // Step 8
        productsPage.clickViewCartOnModal();

        // Step 9
        Assert.assertTrue(cartPage.verifyNumberOfProductsInCart(2), "Số lượng sản phẩm trong giỏ hàng không đúng là 2.");

        // Step 10
        Assert.assertTrue(cartPage.verifyProductDetails(1), "Thông tin giá, số lượng, tổng tiền của sản phẩm 1 bị sai hoặc không hiển thị.");
        Assert.assertTrue(cartPage.verifyProductDetails(2), "Thông tin giá, số lượng, tổng tiền của sản phẩm 2 bị sai hoặc không hiển thị.");
    }
}