import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase25 {
    @Test
    public void main(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.xpath("//div[@id='slider-carousel']")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ hiển thị thất bại");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            System.out.println("Đã cuộn xuống cuối trang");

            // STep 5
            WebElement subscriptionsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
            Assert.assertTrue(subscriptionsHeader.isDisplayed(), "Header 'Subscription' không hiển thị");
            System.out.println("Header 'Subscription' hiển thị thành công");

            // Step 6
            WebElement moveAwardBtn = driver.findElement(By.id("scrollUp"));
            moveAwardBtn.click();
            System.out.println("Đã nhấn nút 'Move Award'");

            // Step 7
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")));
            boolean textBannerVisible = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")).isDisplayed();
            Assert.assertTrue(textBannerVisible, "Banner hiển thị thất bại");
            System.out.println("Banner hiển thị thành công");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
