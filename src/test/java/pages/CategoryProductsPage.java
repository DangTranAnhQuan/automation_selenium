package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductsPage {
    private WebDriver driver;
    private By categoryTitle = By.xpath("//h2[@class='title text-center']");

    public CategoryProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Lấy nội dung tiêu đề trang danh mục")
    public String getCategoryTitleText() {
        return driver.findElement(categoryTitle).getText();
    }
}