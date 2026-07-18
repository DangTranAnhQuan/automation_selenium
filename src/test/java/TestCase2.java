import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestCase2 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
 
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        try{
            // step 1 and 2
            driver.get("https://automationexercise.com/");
 
            //step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");
 
            // step 4
            WebElement signUpBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            signUpBtn.click();
            System.out.println("Đã nhấn vào nút SignUp/Login");
 
            //Step 5
            WebElement isLoginHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]"));
            Assert.assertTrue(isLoginHeaderVisible.isDisplayed(), "Form 'Login to your account' không hiển thị.");
            System.out.println("Form Login hiển thị thành công");
 
            //Step 6
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            inputEmail.sendKeys("dangquan1912@gmail.com");
            WebElement inputPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
            inputPassword.sendKeys("123456");
 
            //Step 7
            WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
            loginBtn.click();
            System.out.println("Đã nhấn vào nút Login");
 
            //Step 8
            WebElement loggedAsHeader = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]"));
            Assert.assertTrue(loggedAsHeader.isDisplayed(), "Header 'Logged in as' không hiển thị.");
            System.out.println("Trang 'Logged in as' hiển thị thành công");
 
            //Step 9
            WebElement deleteBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
            deleteBtn.click();
            System.out.println("Đã nhấn vào nút Delete Account");
 
            //Step 10
            WebElement accountDeletedHeader = driver.findElement(By.xpath("//b[contains(text(), 'Account Deleted!')]"));
            Assert.assertTrue(accountDeletedHeader.isDisplayed(), "Trang 'Account Deleted!' không hiển thị.");
            System.out.println("Trang 'Account Deleted!' hiển thị thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Đang đóng trình duyệt");
            driver.quit();
        }
    }
}
