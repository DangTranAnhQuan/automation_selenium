package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By cartInfoTable = By.id("cart_info_table");
    private By cartProductRows = By.xpath("//table[@id='cart_info_table']/tbody/tr");
    private By cartQuantityBtn = By.xpath("//td[@class='cart_quantity']/button");
    private By cartInfo = By.id("cart_info");
    private By proceedToCheckoutBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private By registerLoginModalBtn = By.xpath("//div[@class='modal-content']//a[@href='/login']");
    private By deleteProductBtn = By.xpath("//a[@class='cart_quantity_delete']");
    private By productRow1 = By.xpath("//tr[@id='product-1']");
    private By cartItemsRows = By.xpath("//tbody/tr");

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

    @Step("Lấy số lượng hiển thị của sản phẩm trong giỏ hàng")
    public String getProductQuantity() {
        return driver.findElement(cartQuantityBtn).getText();
    }

    @Step("Kiểm tra trang Giỏ hàng hiển thị")
    public boolean isCartPageVisible() {
        return driver.findElement(cartInfo).isDisplayed();
    }

    @Step("Nhấn nút 'Proceed To Checkout'")
    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    @Step("Nhấn nút 'Register / Login' trên Modal")
    public void clickRegisterLoginOnModal() {
        driver.findElement(registerLoginModalBtn).click();
    }

    @Step("Nhấn nút 'X' tương ứng để xóa sản phẩm")
    public void clickDeleteProduct() {
        WebElement deleteBtn = driver.findElement(deleteProductBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);
    }

    @Step("Kiểm tra sản phẩm đã bị xóa khỏi giỏ hàng")
    public boolean isProductRemoved() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Sử dụng invisibility thay vì isDisplayed để tránh lỗi NoSuchElementException khi phần tử không còn tồn tại
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(productRow1));
    }

    @Step("Lấy tổng số lượng sản phẩm đang hiển thị trong giỏ hàng")
    public int getCartItemsCount() {
        return driver.findElements(cartItemsRows).size();
    }
}