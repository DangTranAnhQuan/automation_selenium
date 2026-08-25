package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandProductsPage {
    private WebDriver driver;
    private By brandTitle = By.xpath("//h2[@class='title text-center']");

    public BrandProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Lấy nội dung tiêu đề trang thương hiệu")
    public String getBrandTitleText() {
        return driver.findElement(brandTitle).getText();
    }
}