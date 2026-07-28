import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase19 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            driver.findElement(By.xpath("//a[@href='/products']")).click();
            System.out.println("Đã nhấn vào nút Products");

            // Step 4
            WebElement categoryVisible = driver.findElement(By.xpath("//div[@class='brands_products']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", categoryVisible);
            Assert.assertTrue(categoryVisible.isDisplayed(), "Danh mục hiển thị thất bại");
            System.out.println("Danh mục hiển thị thành công");

            // Step 5
            driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
            System.out.println("Đã nhấn vào danh mục Polo");

            // Step 6
            WebElement PoloCategoryVisible = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertEquals(PoloCategoryVisible.getText(), "BRAND -  Polo PRODUCTS", "Danh mục Polo hiển thị thất bại");

            // Step 7
            driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).click();
            System.out.println("Đã nhấn vào danh mục H&M");

            // Step 8
            WebElement HMCategoryVisible = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertEquals(HMCategoryVisible.getText(), "BRAND - H&M PRODUCTS", "Danh mục H&M hiển thị thất bại");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
