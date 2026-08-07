package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By sliderCarousel = By.id("slider-carousel");
    private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By loggedInUserHeader = By.xpath("//a[contains(text(),'Logged in as')]");
    private By deleteAccountBtn = By.xpath("//a[@href='/delete_account']");
    private By logoutBtn = By.xpath("//a[@href='/logout']");
    private  By contactUsBtn = By.xpath("//a[@href='/contact_us']");
    private  By testCaseBtn = By.xpath("//a[@href='/test_cases']");
    private By productsBtn = By.xpath("//a[@href='/products']");
    private By footerSection = By.xpath("//footer[@id='footer']");
    private By subscriptionHeader = By.xpath("//h2[contains(text(),'Subscription')]");
    private By subscribeEmailInput = By.id("susbscribe_email");
    private By subscribeBtn = By.id("subscribe");
    private By subscribeSuccessMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");
    private By cartBtn = By.xpath("//a[@href='/view_cart']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Kiểm tra trang chủ hiển thị thành công")
    public boolean isHomePageVisible() {
        return driver.findElement(sliderCarousel).isDisplayed();
    }

    @Step("Nhấp vào nút 'Signup / Login'")
    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    @Step("Kiểm tra thông báo 'Logged in as username' hiển thị")
    public boolean isLoggedInUserVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserHeader)).isDisplayed();
    }

    @Step("Nhấp vào nút 'Contact us'")
    public void clickContactUs() {
        driver.findElement(contactUsBtn).click();
    }

    @Step("Nhấp vào nút Test Cases")
    public void clickTestCases() {
        driver.findElement(testCaseBtn).click();
    }

    @Step("Nhấp vào nút 'Products'")
    public void clickProducts(){
        driver.findElement(productsBtn).click();
    }

    @Step("Cuộn trang xuống phần Footer")
    public void scrollToFooter() {
        WebElement footer = driver.findElement(footerSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    }

    @Step("Kiểm tra Header 'SUBSCRIPTION' hiển thị")
    public boolean isSubscriptionHeaderVisible() {
        return driver.findElement(subscriptionHeader).isDisplayed();
    }

    @Step("Nhập email '{email}' và nhấn nút mũi tên để đăng ký")
    public void subscribeToNewsletter(String email) {
        driver.findElement(subscribeEmailInput).sendKeys(email);
        driver.findElement(subscribeBtn).click();
    }

    @Step("Kiểm tra thông báo đăng ký thành công hiển thị")
    public boolean isSubscriptionSuccessMessageVisible() {
        return driver.findElement(subscribeSuccessMessage).isDisplayed();
    }

    @Step("Nhấp vào nút 'Cart' trên thanh điều hướng")
    public void clickCart() {
        driver.findElement(cartBtn).click();
    }

    @Step("Nhấp vào nút 'Logout'")
    public void ClickLogout(){
        driver.findElement(logoutBtn).click();
    }

    @Step("Nhấp vào nút 'Delete Account'")
    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }
}