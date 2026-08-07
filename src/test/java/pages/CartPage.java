package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By cartInfoTable = By.id("cart_info_table");
    private By cartProductRows = By.xpath("//table[@id='cart_info_table']/tbody/tr");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra có đúng {expectedCount} sản phẩm được thêm vào giỏ hàng")
    public boolean verifyNumberOfProductsInCart(int expectedCount) {
        List<WebElement> products = driver.findElements(cartProductRows);
        return products.size() == expectedCount;
    }

    @Step("Kiểm tra thông tin chi tiết (Price, Quantity, Total) của sản phẩm ở hàng {rowNumber}")
    public boolean verifyProductDetails(int rowNumber) {
        String rowXPath = "//table[@id='cart_info_table']/tbody/tr[" + rowNumber + "]";

        WebElement price = driver.findElement(By.xpath(rowXPath + "//td[@class='cart_price']/p"));
        WebElement quantity = driver.findElement(By.xpath(rowXPath + "//td[@class='cart_quantity']/button"));
        WebElement total = driver.findElement(By.xpath(rowXPath + "//td[@class='cart_total']/p"));

        boolean isPriceValid = price.isDisplayed() && !price.getText().isEmpty();
        boolean isQuantityValid = quantity.isDisplayed() && !quantity.getText().isEmpty();
        boolean isTotalValid = total.isDisplayed() && !total.getText().isEmpty();

        return isPriceValid && isQuantityValid && isTotalValid;
    }
}