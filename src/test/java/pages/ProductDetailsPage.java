package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private WebDriver driver;
    private By productNameHeader = By.xpath("//h2[contains(text(),'Blue Top')]");
    private By productInformationDetails = By.xpath("//div[@class='product-information']");

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
}