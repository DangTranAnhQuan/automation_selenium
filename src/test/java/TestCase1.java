import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestCase1 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--incognito", "--start-maximized");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String dynamicEmail = "dangquan" + System.currentTimeMillis() + "@gmail.com";

        try {
            // step 1 and 2
            System.out.println("Đang mở trang web...");
            driver.get("https://automationexercise.com/");

            // step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công.");

            // step 4
            WebElement SignUpOrLoginBtn = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
            SignUpOrLoginBtn.click();
            System.out.println("Đã nhấp vào nút 'Signup / Login'.");

            // step 5
            WebElement signupHeader = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
            Assert.assertTrue(signupHeader.isDisplayed(), "Trang New User Signup! không hiển thị.");
            System.out.println("Trang 'New User Signup!' hiển thị thành công.");

            // step 6
            WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
            inputName.sendKeys("AnhQuan");
            WebElement inputMail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            inputMail.sendKeys(dynamicEmail); // Sử dụng email động

            // step 7
            WebElement signupBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signupBtn.click();
            System.out.println("Đã nhấp vào nút 'Signup'.");

            // step 8
            WebElement enterAccountInformationHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Enter Account Information')]")));
            Assert.assertTrue(enterAccountInformationHeader.isDisplayed(), "Trang Enter Account Information không hiển thị.");
            System.out.println("Trang 'Enter Account Information' hiển thị thành công.");

            // step 9
            WebElement titleMrRadioGender = driver.findElement(By.id("id_gender1"));
            titleMrRadioGender.click();
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("123456");
            Select dayDropdown = new Select(driver.findElement(By.id("days")));
            dayDropdown.selectByValue("19");
            Select monthDropdown = new Select(driver.findElement(By.id("months")));
            monthDropdown.selectByValue("12");
            Select yearDropdown = new Select(driver.findElement(By.id("years")));
            yearDropdown.selectByValue("2004");

            // step 10
            WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
            js.executeScript("arguments[0].scrollIntoView(true);", newsletterCheckbox);
            wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox)).click();

            //step 11
            WebElement offerCheckbox = driver.findElement(By.id("optin"));
            js.executeScript("arguments[0].scrollIntoView(true);", offerCheckbox);
            wait.until(ExpectedConditions.elementToBeClickable(offerCheckbox)).click();

            // step 12
            WebElement firstName = driver.findElement(By.id("first_name"));
            firstName.sendKeys("Anh");
            WebElement lastName = driver.findElement(By.id("last_name"));
            lastName.sendKeys("Quan");
            WebElement company = driver.findElement(By.id("company"));
            company.sendKeys("FPT");
            WebElement address1 = driver.findElement(By.id("address1"));
            address1.sendKeys("123 Đường ABC");
            WebElement address2 = driver.findElement(By.id("address2"));
            address2.sendKeys("456 Đường XYZ");
            WebElement country = driver.findElement(By.id("country"));
            country.sendKeys("Canada");
            WebElement state = driver.findElement(By.id("state"));
            state.sendKeys("Ontario");
            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("Toronto");
            WebElement zipcode = driver.findElement(By.id("zipcode"));
            zipcode.sendKeys("123456");
            WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
            mobileNumber.sendKeys("0987654321");

            //step 13
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
            js.executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
            wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
            System.out.println("Đã nhấp vào nút 'Create Account'.");

            //step 14
            WebElement accountCreatedHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Account Created!')]")));
            Assert.assertTrue(accountCreatedHeader.isDisplayed(), "Trang Account Created! không hiển thị.");
            System.out.println("Trang 'Account Created!' hiển thị thành công.");

            // step 15 - Dùng JS Click để tránh quảng cáo Google che lấp
            WebElement continueBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            js.executeScript("arguments[0].click();", continueBtn);
            System.out.println("Đã nhấp vào nút 'Continue'.");

            // step 16
            WebElement loggedAsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));
            Assert.assertTrue(loggedAsHeader.isDisplayed(), "Trang 'Logged in as' không hiển thị.");
            System.out.println("Trang 'Logged in as' hiển thị thành công.");

            // step 17
            WebElement deleteBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
            deleteBtn.click();
            System.out.println("Đã nhấp vào nút 'Delete Account'.");

            // step 18
            WebElement accountDeletedHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Account Deleted!')]")));
            Assert.assertTrue(accountDeletedHeader.isDisplayed(), "Thông báo 'Account Deleted!' không hiển thị.");
            System.out.println("Trang 'Account Deleted!' hiển thị thành công.");

            // Dùng JS Click để tránh quảng cáo khi tiếp tục
            WebElement continueBtnAfterDelete = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            js.executeScript("arguments[0].click();", continueBtnAfterDelete);
            System.out.println("Đã nhấp vào nút 'Continue' sau khi xóa.");

        } catch (TimeoutException e) {
            System.err.println("Lỗi: Một phần tử không được tìm thấy hoặc không hiển thị trong thời gian chờ.");
            e.printStackTrace();
            Assert.fail("Test thất bại do TimeoutException.", e);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test thất bại do một Exception không mong muốn.", e);
        } finally {
            System.out.println("Đang đóng trình duyệt...");
            driver.quit();
        }
    }
}