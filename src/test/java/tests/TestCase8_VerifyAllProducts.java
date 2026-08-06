package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

@Epic("Products")
@Feature("Product Visibility and Details")
public class TestCase8_VerifyAllProducts extends BaseTest {

    @Test(description = "Test Case 8: Verify All Products and product detail page")
    @Description("Xác minh người dùng có thể xem danh sách toàn bộ sản phẩm và xem chi tiết của một sản phẩm cụ thể")
    public void testVerifyAllProductsAndDetails() {
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickProducts();

        // Step 5
        Assert.assertTrue(productsPage.isAllProductsHeaderVisible(), "Trang 'All Products' không hiển thị.");

        // Step 6
        Assert.assertTrue(productsPage.isProductListVisible(), "Danh sách sản phẩm không hiển thị.");

        // Step 7
        productsPage.clickViewFirstProduct();

        // Step 8
        Assert.assertTrue(productDetailsPage.isProductNameVisible(), "Tiêu đề trang chi tiết sản phẩm không hiển thị.");

        // Step 9
        Assert.assertTrue(productDetailsPage.isProductInformationVisible(), "Phần thông tin sản phẩm không hiển thị.");
    }
}