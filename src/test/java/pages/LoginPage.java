package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By signupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    private By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");
    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    private By signUpErrorMessage = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra header 'New User Signup!' hiển thị")
    public boolean isSignupHeaderVisible() {
        return driver.findElement(signupHeader).isDisplayed();
    }

    @Step("Nhập tên: {name} và email: {email} sau đó nhấn Signup")
    public void signupNewUser(String name, String email) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    public boolean isLoginHeaderVisible() {
        return driver.findElement(loginHeader).isDisplayed();
    }

    public void login(String email, String password){
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginErrorVisible(){
        return driver.findElement(loginErrorMessage).isDisplayed();
    }

    public boolean isSignupErrorVisible(){
        return driver.findElement(signUpErrorMessage).isDisplayed();
    }

}