package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @Step("Nhấp vào nút 'Logout'")
    public void ClickLogout(){
        driver.findElement(logoutBtn).click();
    }

    @Step("Nhấp vào nút 'Delete Account'")
    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }
}