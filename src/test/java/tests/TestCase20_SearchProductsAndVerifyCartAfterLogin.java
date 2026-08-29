package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

@Epic("E2E")
@Feature("Search and Cart Synchronization")
public class TestCase20_SearchProductsAndVerifyCartAfterLogin extends BaseTest {

    @Test(description = "Test Case 20: Search Products and Verify Cart After Login")
    @Description("Xác minh sản phẩm được thêm vào giỏ hàng khi chưa đăng nhập vẫn được giữ nguyên sau khi đăng nhập")
    public void testSearchProductsAndVerifyCartAfterLogin() {
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Steps 3-7: Navigation & Search
        homePage.clickProducts(); 
        Assert.assertTrue(productsPage.isAllProductsHeaderVisible(), "Trang sản phẩm hiển thị thất bại"); 
        productsPage.searchProduct("top"); 
        Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(), "Kết quả tìm kiếm hiển thị thất bại"); 
        Assert.assertTrue(productsPage.areSearchedProductsRelatedToKeyword("top"), "Không có sản phẩm nào!"); 

        // Step 8: Add products to cart
        int addedProductsCount = productsPage.addAllSearchedProductsToCart(); 

        // Step 9: Verify cart before login
        homePage.clickCart(); 
        Assert.assertEquals(cartPage.getCartItemsCount(), addedProductsCount, "Số lượng sản phẩm trong giỏ không khớp."); 

        // Step 10: Login
        homePage.clickSignupLogin(); 
        loginPage.login("dangquan1912@gmail.com", "123456"); 

        // Step 11 and 12: Verify cart after login
        homePage.clickCart(); 
        Assert.assertEquals(cartPage.getCartItemsCount(), addedProductsCount, "Số lượng sản phẩm bị mất sau khi đăng nhập."); 
    }
}