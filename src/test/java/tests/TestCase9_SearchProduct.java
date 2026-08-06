package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

@Epic("Products")
@Feature("Search Feature")
public class TestCase9_SearchProduct extends BaseTest {

    @Test(description = "Test Case 9: Search Product")
    @Description("Xác minh người dùng có thể tìm kiếm sản phẩm và các kết quả trả về hiển thị chính xác theo từ khóa")
    public void testSearchProduct() {
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        String searchKeyword = "top";

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickProducts();

        // Step 5
        Assert.assertTrue(productsPage.isAllProductsHeaderVisible(), "Trang 'All Products' không hiển thị.");

        // Step 6
        productsPage.searchProduct(searchKeyword);

        // Step 7
        Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(), "Header 'Searched Products' không hiển thị.");
        // Step 8
        Assert.assertTrue(productsPage.areSearchedProductsRelatedToKeyword(searchKeyword),
                "Có sản phẩm không chứa từ khóa tìm kiếm: " + searchKeyword);
    }
}