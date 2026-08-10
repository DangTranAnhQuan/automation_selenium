package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private By addressDetailsHeader = By.xpath("//h2[contains(text(),'Address Details')]");
    private By reviewOrderHeader = By.xpath("//h2[contains(text(),'Review Your Order')]");
    private By commentTextarea = By.xpath("//textarea[@name='message']");
    private By placeOrderBtn = By.xpath("//a[@class='btn btn-default check_out']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra thông tin địa chỉ hiển thị")
    public boolean isAddressDetailsVisible() {
        return driver.findElement(addressDetailsHeader).isDisplayed();
    }

    @Step("Kiểm tra phần Review Order hiển thị")
    public boolean isReviewOrderVisible() {
        return driver.findElement(reviewOrderHeader).isDisplayed();
    }

    @Step("Nhập ghi chú '{comment}' và nhấn 'Place Order'")
    public void enterCommentAndPlaceOrder(String comment) {
        driver.findElement(commentTextarea).sendKeys(comment);
        driver.findElement(placeOrderBtn).click();
    }
}