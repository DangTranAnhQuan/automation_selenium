import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestCase13 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công ");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement viewProductBtn = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
            viewProductBtn.click();
            System.out.println("Đã nhấn nút View Product");

            // Step 5
            boolean isProductDetailVisible = driver.findElement(By.xpath("//div[@class='product-details']")).isDisplayed();
            Assert.assertTrue(isProductDetailVisible, "Chi tiết sản phẩm không hiển thị.");
            System.out.println("Chi tiết sản phẩm hiển thị thành công");

            // Step 6
            WebElement inputQuantity = driver.findElement(By.id("quantity"));
            inputQuantity.clear();
            inputQuantity.sendKeys("4");
            System.out.println("Đã nhập số lượng sản phẩm");

            // Step 7
            WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='btn btn-default cart']"));
            addToCartBtn.click();
            System.out.println("Đã nhấn nút Add to cart");

            // Step 8
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            System.out.println("Modal hiển thị thành công");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='/view_cart']")));
            System.out.println("Đã nhấn nút View Cart");

            // Step 9
            String quantityInCart = driver.findElement(By.xpath("//td[@class='cart_quantity']/button")).getText();
            Assert.assertEquals(quantityInCart, "4", "Số lượng sản phẩm trong giỏ hàng không chính xác.");
            System.out.println("Số lượng sản phẩm trong giỏ hàng hiển thị chính xác");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
