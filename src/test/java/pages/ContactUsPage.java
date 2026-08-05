package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    private WebDriver driver;

    // Locators
    private By getInTouchHeader = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private By nameInput = By.xpath("//input[@data-qa='name']");
    private By emailInput = By.xpath("//input[@data-qa='email']");
    private By subjectInput = By.xpath("//input[@data-qa='subject']");
    private By messageInput = By.xpath("//textarea[@data-qa='message']");
    private By uploadFileInput = By.xpath("//input[@name='upload_file']");
    private By submitBtn = By.xpath("//input[@data-qa='submit-button']");
    private By successMsg = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
    private By homeBtn = By.xpath("//a[@class='btn btn-success']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra Header 'GET IN TOUCH' hiển thị")
    public boolean isGetInTouchVisible() {
        return driver.findElement(getInTouchHeader).isDisplayed();
    }

    @Step("Điền thông tin liên hệ: Tên {0}, Email {1}, Tiêu đề {2}, Lời nhắn {3}")
    public void fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subjectInput).sendKeys(subject);
        driver.findElement(messageInput).sendKeys(message);
    }

    @Step("Tải lên tệp từ đường dẫn: {0}")
    public void uploadFile(String filePath) {
        driver.findElement(uploadFileInput).sendKeys(filePath);
    }

    @Step("Nhấp vào nút 'Submit'")
    public void clickSubmit() {
        WebElement submitButton = driver.findElement(submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }

    @Step("Chấp nhận Browser Alert")
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Kiểm tra thông báo gửi thành công hiển thị")
    public boolean isSuccessMessageVisible() {
        return driver.findElement(successMsg).isDisplayed();
    }

    @Step("Nhấp vào nút 'Home' để quay về trang chủ")
    public void clickHomeBtn() {
        driver.findElement(homeBtn).click();
    }
}