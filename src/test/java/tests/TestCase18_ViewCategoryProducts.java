package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryProductsPage;
import pages.HomePage;

@Epic("Products")
@Feature("Category")
public class TestCase18_ViewCategoryProducts extends BaseTest {

    @Test(description = "Test Case 18: View Category Products")
    @Description("Xác minh người dùng có thể xem và điều hướng giữa các danh mục sản phẩm (Women, Men) ở thanh menu bên trái")
    public void testViewCategoryProducts() {
        HomePage homePage = new HomePage(driver);
        CategoryProductsPage categoryProductsPage = new CategoryProductsPage(driver);

        // Step 3
        Assert.assertTrue(homePage.isCategorySidebarVisible(), "Danh mục sản phẩm không hiển thị");

        // Step 4
        homePage.clickWomenCategory();

        // Step 5
        homePage.clickDressSubCategory();

        // Step 6
        Assert.assertEquals(categoryProductsPage.getCategoryTitleText(), "WOMEN -  Dress PRODUCTS", "Sai tiêu đề danh mục!");

        // Step 7
        homePage.clickMenCategory();
        homePage.clickTshirtsSubCategory();

        // Step 8
        Assert.assertEquals(categoryProductsPage.getCategoryTitleText(), " Men -  Tshirts PRODUCTS", "Sai tiêu đề danh mục!");
    }
}