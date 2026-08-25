package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandProductsPage;
import pages.HomePage;
import pages.ProductsPage;

@Epic("Products")
@Feature("Brands")
public class TestCase19_ViewBrandProducts extends BaseTest {

    @Test(description = "Test Case 19: View & Cart Brand Products")
    @Description("Xác minh người dùng có thể xem và điều hướng giữa các thương hiệu sản phẩm (Polo, H&M) ở thanh menu bên trái")
    public void testViewBrandProducts() {
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        BrandProductsPage brandProductsPage = new BrandProductsPage(driver);

        // Step 3
        homePage.clickProducts();

        // Step 4
        Assert.assertTrue(productsPage.isBrandsSidebarVisible(), "Danh mục thương hiệu hiển thị thất bại");

        // Step 5
        productsPage.clickPoloBrand();

        // Step 6
        Assert.assertEquals(brandProductsPage.getBrandTitleText(), "BRAND -  Polo PRODUCTS", "Danh mục Polo hiển thị thất bại");

        // Step 7
        productsPage.clickHMBrand();

        // Step 8
        Assert.assertEquals(brandProductsPage.getBrandTitleText(), "BRAND - H&M PRODUCTS", "Danh mục H&M hiển thị thất bại");
    }
}