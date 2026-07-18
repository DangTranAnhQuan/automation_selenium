import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestCase11 {
    @Test
    public void main() {
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
            WebElement cartbtn = driver.findElement(By.xpath("//a[@href='/view_cart']"));
            cartbtn.click();
            System.out.println("Đã nhấn nút Cart");

            // Step 5
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement scrollToBottom = driver.findElement(By.xpath("//footer[@id='footer']"));
            js.executeScript("arguments[0].scrollIntoView(true);", scrollToBottom);
            sleep(2000);
            System.out.println("Đã cuộn xuống cuối trang");

            // Step 6
            boolean isSubscriptionHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]")).isDisplayed();
            Assert.assertTrue(isSubscriptionHeaderVisible, "Phần SUBSCRIPTION không hiển thị.");
            System.out.println("Phần SUBSCRIPTION hiển thị thành công");

            // Step 7
            WebElement inputEmail = driver.findElement(By.id("susbscribe_email"));
            inputEmail.sendKeys("dangquan1912@gmail.com");
            WebElement subscribeBtn = driver.findElement(By.id("subscribe"));
            subscribeBtn.click();
            System.out.println("Đã nhập email và nhấn nút Subscribe");

            // Step 8
            boolean isSuccessMessageVisible = driver.findElement(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]")).isDisplayed();
            Assert.assertTrue(isSuccessMessageVisible, "Thông báo 'You have been successfully subscribed!' không hiển thị.");
            System.out.println("Thông báo You have been successfully subscribed! hiển thị thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}