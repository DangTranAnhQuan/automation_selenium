package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

@Epic("Cart")
@Feature("Product Quantity")
public class TestCase13_VerifyProductQuantity extends BaseTest {

    @Test(description = "Test Case 13: Verify Product quantity in Cart")
    @Description("Xác minh người dùng có thể thay đổi số lượng sản phẩm ở trang chi tiết và giỏ hàng hiển thị chính xác số lượng đó")
    public void testVerifyProductQuantity() {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CartPage cartPage = new CartPage(driver);
        String targetQuantity = "4";

        // Step 3
        Assert.assertTrue(homePage.isHomePageVisible(), "Trang chủ không hiển thị.");

        // Step 4
        homePage.clickViewProduct();

        // Step 5
        Assert.assertTrue(productDetailsPage.isProductDetailVisible(), "Chi tiết sản phẩm không hiển thị.");

        // Step 6
        productDetailsPage.setProductQuantity(targetQuantity);

        // Step 7
        productDetailsPage.clickAddToCart();

        // Step 8
        productDetailsPage.clickViewCartOnModal();

        // Step 9
        String actualQuantity = cartPage.getProductQuantity();
        Assert.assertEquals(actualQuantity, targetQuantity, "Số lượng sản phẩm trong giỏ hàng không chính xác.");
    }
}