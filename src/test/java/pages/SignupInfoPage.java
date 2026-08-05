package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private By enterAccountInfoHeader = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private By titleMrRadio = By.id("id_gender1");
    private By passwordInput = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offerCheckbox = By.id("optin");

    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    private By accountCreatedHeader = By.xpath("//b[contains(text(),'Account Created!')]");
    private By accountDeletedHeader = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public SignupInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    @Step("Kiểm tra header 'Enter Account Information' hiển thị")
    public boolean isEnterAccountInfoHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(enterAccountInfoHeader)).isDisplayed();
    }

    @Step("Điền thông tin tài khoản (Title, Password, Date of birth)")
    public void fillAccountInformation(String password, String day, String month, String year) {
        driver.findElement(titleMrRadio).click();
        driver.findElement(passwordInput).sendKeys(password);
        new Select(driver.findElement(daysDropdown)).selectByValue(day);
        new Select(driver.findElement(monthsDropdown)).selectByValue(month);
        new Select(driver.findElement(yearsDropdown)).selectByValue(year);
    }

    @Step("Chọn các checkbox Newsletter và Special Offers")
    public void selectCheckboxes() {
        WebElement newsletter = driver.findElement(newsletterCheckbox);
        js.executeScript("arguments[0].scrollIntoView(true);", newsletter);
        wait.until(ExpectedConditions.elementToBeClickable(newsletter)).click();

        WebElement offer = driver.findElement(offerCheckbox);
        js.executeScript("arguments[0].scrollIntoView(true);", offer);
        wait.until(ExpectedConditions.elementToBeClickable(offer)).click();
    }

    @Step("Điền thông tin địa chỉ chi tiết")
    public void fillAddressDetails(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobile) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(companyInput).sendKeys(company);
        driver.findElement(address1Input).sendKeys(address1);
        driver.findElement(address2Input).sendKeys(address2);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipcodeInput).sendKeys(zipcode);
        driver.findElement(mobileNumberInput).sendKeys(mobile);
    }

    @Step("Nhấn nút Create Account")
    public void clickCreateAccount() {
        WebElement createBtn = driver.findElement(createAccountBtn);
        js.executeScript("arguments[0].scrollIntoView(true);", createBtn);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn)).click();
    }

    @Step("Kiểm tra thông báo 'Account Created!' và nhấn Continue")
    public boolean verifyAccountCreatedAndContinue() {
        boolean isCreated = wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedHeader)).isDisplayed();
        WebElement contBtn = driver.findElement(continueBtn);
        js.executeScript("arguments[0].click();", contBtn);
        return isCreated;
    }

    @Step("Kiểm tra thông báo 'Account Deleted!' và nhấn Continue")
    public boolean verifyAccountDeletedAndContinue() {
        boolean isDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedHeader)).isDisplayed();
        WebElement contBtn = driver.findElement(continueBtn);
        js.executeScript("arguments[0].click();", contBtn);
        return isDeleted;
    }
}