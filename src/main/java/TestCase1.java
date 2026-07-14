import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestCase1 {
    public static void main() {
        ChromeOptions  options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        try{
            // step 1 and 2
            System.out.println("Đang mở trang web...");
            driver.get("https://automationexercise.com/");

            // step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            if (isHomePageVisible) {
                System.out.println("Trang chủ hiển thị thành công.");
            } else {
                System.out.println("Trang chủ không hiển thị.");
            }

            // step 4
            WebElement SignUpOrLoginBtn = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
            SignUpOrLoginBtn.click();
            System.out.println("Đã nhấp vào nút 'Signup / Login'.");

            // step 5
            WebElement signupHeader = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
            if (signupHeader.isDisplayed())
                System.out.println("Trang 'New User Signup!' hiển thị thành công.");
            else
                System.out.println("Trang 'New User Signup!' không hiển thị.");

            // step 6
            WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
            inputName.sendKeys("AnhQuan");
            WebElement inputMail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            inputMail.sendKeys("dangquan1912@gmail.com");

            // step 7
            WebElement signupBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signupBtn.click();
            System.out.println("Đã nhấp vào nút 'Signup'.");

            // step 8
            WebElement enterAccountInformationHeader = driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]"));
            if (enterAccountInformationHeader.isDisplayed())
                System.out.println("Trang 'Enter Account Information' hiển thị thành công.");
            else
                System.out.println("Trang 'Enter Account Information' không hiển thị.");

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
            newsletterCheckbox.click();

            //step 11
            WebElement offerCheckbox = driver.findElement(By.id("optin"));
            offerCheckbox.click();

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
            country.click();
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
            createAccountBtn.click();
            System.out.println("Đã nhấp vào nút 'Create Account'.");

            //step 14
            WebElement accountCreatedHeader = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]"));
            if (accountCreatedHeader.isDisplayed())
                System.out.println("Trang 'Account Created!' hiển thị thành công.");
            else
                System.out.println("Trang 'Account Created!' không hiển thị.");

            //step 15
            WebElement continueBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            continueBtn.click();
            System.out.println("Đã nhấp vào nút 'Continue'.");

            //step 16
            WebElement loggedAsHeader = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
            if (loggedAsHeader.isDisplayed())
                System.out.println("Trang 'Logged in as' hiển thị thành công.");
            else
                System.out.println("Trang 'Logged in as' không hiển thị.");

            //step 17
            WebElement deleteAccountBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
            deleteAccountBtn.click();
            System.out.println("Đã nhấp vào nút 'Delete Account'.");


            //step 18
            WebElement continueBtnAfterDeleted = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            continueBtnAfterDeleted.click();
            System.out.println("Đã nhấp vào nút 'Continue'.");

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Đang đóng trình duyệt...");
            driver.quit();
        }
    }
}
