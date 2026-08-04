import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase21 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Step 1 and 2
            driver.get("https://automationexercise.com/");

            // Step 3
            driver.findElement(By.xpath("//a[@href='/products']")).click();

            // Step 4
            driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
            Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='title text-center']")).getText(), "ALL PRODUCTS", "Trang sản phẩm hiển thị thất bại");
            System.out.println("Trang sản phẩm hiển thị thành công");

            // Step 5
            driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

            // Step 6
            driver.findElement(By.xpath("//a[@href='#reviews']")).isDisplayed();
            Assert.assertEquals(driver.findElement(By.xpath("//a[@href='#reviews']")).getText(), "WRITE YOUR REVIEW", "Write your review không hiển thị");
            System.out.println("Write your review hiển thị thành công");

            // Step 7
            driver.findElement(By.id("name")).sendKeys("Nguyen Van A");
            driver.findElement(By.id("email")).sendKeys("dangquan1912@gmail.com");
            driver.findElement(By.id("review")).sendKeys("Sản phẩm rất tốt, tôi rất hài lòng với chất lượng và dịch vụ của cửa hàng. Sẽ tiếp tục ủng hộ trong tương lai!");

            // Step 8
            driver.findElement(By.id("button-review")).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
