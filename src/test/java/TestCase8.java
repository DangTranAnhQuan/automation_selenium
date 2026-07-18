import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase8 {
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
            Assert.assertTrue(isHomePageVisible, "Home page is not visible.");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement productBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productBtn.click();
            System.out.println("Đã nhấn nút Products");

            // Step 5
            boolean isAllProductsHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed();
            Assert.assertTrue(isAllProductsHeaderVisible, "'All Products' page is not visible.");
            System.out.println("Trang 'All Products' hiển thị thành công");

            // Step 6
            WebElement productsList = driver.findElement(By.xpath("//div[@class='product-image-wrapper']"));
            Assert.assertTrue(productsList.isDisplayed(), "Product list is not visible.");
            System.out.println("Danh sách sản phẩm hiển thị thành công");

            // Step 7
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement viewProductBtn = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
            js.executeScript("arguments[0].click();", viewProductBtn);
            System.out.println("Đã nhấn nút View Product");

            // Step 8
            boolean isProductDetailsHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]")).isDisplayed();
            Assert.assertTrue(isProductDetailsHeaderVisible, "Product detail page header is not visible.");
            System.out.println("Trang 'Product Details' hiển thị thành công");

            // Step 9
            WebElement productDetails = driver.findElement(By.xpath("//div[@class='product-information']"));
            Assert.assertTrue(productDetails.isDisplayed(), "Product information section is not visible.");
            System.out.println("Chi tiết sản phẩm hiển thị thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
