package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    private WebDriver driver;
    private By productNameHeader = By.xpath("//h2[contains(text(),'Blue Top')]");
    private By productInformationDetails = By.xpath("//div[@class='product-information']");
    private By productDetailsSection = By.xpath("//div[@class='product-details']");
    private By quantityInput = By.id("quantity");
    private By addToCartBtn = By.xpath("//button[@class='btn btn-default cart']");
    private By modalContent = By.xpath("//div[@class='modal-content']");
    private By viewCartModalBtn = By.xpath("//a[@href='/view_cart']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra trang chi tiết sản phẩm hiển thị (Tên sản phẩm xuất hiện)")
    public boolean isProductNameVisible() {
        return driver.findElement(productNameHeader).isDisplayed();
    }

    @Step("Kiểm tra các chi tiết hiển thị: product name, category, price, availability, condition, brand")
    public boolean isProductInformationVisible() {
        return driver.findElement(productInformationDetails).isDisplayed();
    }
    @Step("Kiểm tra chi tiết sản phẩm hiển thị")
    public boolean isProductDetailVisible() {
        return driver.findElement(productDetailsSection).isDisplayed();
    }

    @Step("Tăng số lượng sản phẩm lên {quantity}")
    public void setProductQuantity(String quantity) {
        WebElement inputQty = driver.findElement(quantityInput);
        inputQty.clear();
        inputQty.sendKeys(quantity);
    }

    @Step("Nhấp vào nút 'Add to cart'")
    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    @Step("Nhấp vào nút 'View Cart' trên popup modal")
    public void clickViewCartOnModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalContent));

        WebElement viewCartBtn = driver.findElement(viewCartModalBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);
    }
}