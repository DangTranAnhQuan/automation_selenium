import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.Executor;

public class TestCase17 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ hiển thị thất bại");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement addCartBtn = driver.findElement(By.xpath("//a[@data-product-id='1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addCartBtn);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(addCartBtn)).click();
            System.out.println("Đã nhấn nút thêm sản phẩm vào giỏ hàng");

            // Step 5
            driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']")).click();
            System.out.println("Đã nhấn nút View Cart");

            // Step 6
            boolean isCartPageVisible = driver.findElement(By.id("cart_info")).isDisplayed();
            Assert.assertTrue(isCartPageVisible, "Trang giỏ hàng hiển thị thất bại");
            System.out.println("Trang giỏ hàng hiển thị thành công");

            // Step 7
            driver.findElement(By.xpath("//td[@class='cart_delete']")).click();

            // Step 8
            boolean isCartEmpty = driver.findElement(By.xpath("//tr[@id='product-1']")).isDisplayed();
            Assert.assertTrue(isCartEmpty, "Sản phẩm chưa bị xóa khỏi giỏ hàng");
            System.out.println("Sản phẩm đã bị xóa khỏi giỏ hàng thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
