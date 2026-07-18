import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase3 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement signUpLoginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            signUpLoginBtn.click();
            System.out.println("Đã nhấn vào nút SignUp/Login");

            // Step 5
            boolean isLoginHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]")).isDisplayed();
            Assert.assertTrue(isLoginHeaderVisible, "Form 'Login to your account' không hiển thị.");
            System.out.println("Form Login hiển thị thành công");

            // Step 6
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            inputEmail.sendKeys("dangquan@gmail.com");
            WebElement inputPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
            inputPassword.sendKeys("12345");

            // Step 7
            WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
            loginBtn.click();
            System.out.println("Đã nhấn vào nút Login");

            // Step 8
            boolean errorLoginHeaderVisible = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed();
            Assert.assertTrue(errorLoginHeaderVisible, "Thông báo lỗi không hiển thị.");
            System.out.println("Thông báo lỗi hiển thị thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }

    }
}
