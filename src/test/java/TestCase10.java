import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TestCase10 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(options);
        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement scrollFooter = driver.findElement(By.xpath("//footer[@id='footer']"));
            driver.executeScript("arguments[0].scrollIntoView(true);", scrollFooter);
            System.out.println("Đã cuộn xuống footer");

            // Step 5
            boolean isSubscriptionHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]")).isDisplayed();
            Assert.assertTrue(isSubscriptionHeaderVisible, "Header 'SUBSCRIPTION' không hiển thị.");
            System.out.println("Phần SUBSCRIPTION hiển thị thành công");

            // Step 6
            WebElement inputEmail = driver.findElement(By.id("susbscribe_email"));
            inputEmail.sendKeys("dangquan1912@gmail.com");
            WebElement subscribeBtn = driver.findElement(By.id("subscribe"));
            subscribeBtn.click();
            System.out.println("Đã nhập email và nhấn nút Subscribe");

            // Step 7
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
