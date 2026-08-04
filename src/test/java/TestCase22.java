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

public class TestCase22 {
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

            // Step 3 and 4
            WebElement recommendItemsHeader = driver.findElement(By.xpath("//h2[contains(text(),'recommended items')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recommendItemsHeader);

            // Step 5
            By addToCartLocator = By.xpath("//div[@id='recommended-item-carousel']//div[contains(@class,'active')]//a[contains(@class, 'add-to-cart')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement addToCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartLocator));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", addToCartBtn);
            System.out.println("Đã nhấn nút thêm sản phẩm vào giỏ hàng bằng JS");

            // Step 6
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            WebElement viewCartBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']"));
            viewCartBtn.click();

            // Step 7
            driver.findElement(By.xpath("//table[@id='cart_info_table']")).isDisplayed();
            Assert.assertTrue(driver.findElement(By.xpath("//table[@id='cart_info_table']")).isDisplayed(), "Sản phẩm không hiển thị trong giỏ hàng");
            System.out.println("Sản phẩm hiển thị trong giỏ hàng thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
