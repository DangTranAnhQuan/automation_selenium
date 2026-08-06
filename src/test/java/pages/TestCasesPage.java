package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    private WebDriver driver;
    private By testCasesHeader = By.xpath("//b[contains(text(),'Test Cases')]");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra giao diện trang 'Test Cases' hiển thị thành công")
    public boolean isTestCasesPageVisible() {
        return driver.findElement(testCasesHeader).isDisplayed();
    }
}