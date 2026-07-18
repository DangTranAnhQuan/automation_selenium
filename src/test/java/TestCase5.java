import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase5 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            //Step 1 and 2
            driver.get("https://automationexercise.com/");

            //Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");

            //Step 4
            WebElement signUpLoginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            signUpLoginBtn.click();
            System.out.println("Đã nhấn nút SignUp/Login");

            //Step 5
            boolean isHeaderNewUserVisible = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed();
            Assert.assertTrue(isHeaderNewUserVisible, "Form 'New User Signup!' không hiển thị.");
            System.out.println("Form 'New User Signup!' hiển thị thành công");

            //Step 6
            WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
            inputName.sendKeys("Anh Quan");
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            inputEmail.sendKeys("dangquan1912@gmail.com");

            //Step 7
            WebElement signUpBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signUpBtn.click();
            System.out.println("Đã nhấn nút SignUp");

            //Step 8
            WebElement emailExistNotification = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]"));
            Assert.assertTrue(emailExistNotification.isDisplayed(), "Thông báo 'Email Address already exist!' không hiển thị.");
            System.out.println("Thông báo 'Email Address already exist!' hiển thị thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
