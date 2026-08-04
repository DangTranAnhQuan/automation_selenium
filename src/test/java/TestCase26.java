import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase26 {
    @Test
    public void main(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.xpath("//div[@id='slider-carousel']")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ hiển thị thất bại");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            js.executeScript("window.scrollTo(0, document.body.scrollHeight;");
            System.out.println("Đã cuộn xuống cuối trang");

            // Step 5
            WebElement subscriptionsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
            Assert.assertTrue(subscriptionsHeader.isDisplayed(), "Không hiển thị tiêu đề subscription");
            System.out.println("Hiển thị tiêu đề subscription thành công");

            // Step 6
            WebElement moveAwardBtn = driver.findElement(By.id("scrollUp"));
            moveAwardBtn.click();
            System.out.println("Đã nhấn nút cuộn lên đầu trang");

            // Step 7
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h[contains(text(), 'Full-Fledged practice website for Automation Engineers')]")));
            boolean textBanner = driver.findElement(By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]")).isDisplayed();
            Assert.assertTrue(textBanner, "Không hiển thị banner");
            System.out.println("Hiển thị banner thành công");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
