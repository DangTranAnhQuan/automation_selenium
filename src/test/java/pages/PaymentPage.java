package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private By nameOnCardInput = By.name("name_on_card");
    private By cardNumberInput = By.name("card_number");
    private By cvcInput = By.name("cvc");
    private By expiryMonthInput = By.name("expiry_month");
    private By expiryYearInput = By.name("expiry_year");
    private By payAndConfirmBtn = By.id("submit");
    private By successMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Nhập thông tin thanh toán và nhấn 'Pay and Confirm Order'")
    public void fillPaymentDetailsAndConfirm(String name, String card, String cvc, String expMonth, String expYear) {
        driver.findElement(nameOnCardInput).sendKeys(name);
        driver.findElement(cardNumberInput).sendKeys(card);
        driver.findElement(cvcInput).sendKeys(cvc);
        driver.findElement(expiryMonthInput).sendKeys(expMonth);
        driver.findElement(expiryYearInput).sendKeys(expYear);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(payAndConfirmBtn));
    }

    @Step("Kiểm tra thông báo đặt hàng thành công")
    public boolean isOrderPlacedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}