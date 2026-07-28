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
import java.util.List;

public class TestCase20 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            driver.findElement(By.xpath("//a[@href='/products']")).click();
            System.out.println("Đã nhấn vào nút Products");

            // Step 4
            WebElement productPageVisible = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertEquals(productPageVisible.getText(), "ALL PRODUCTS", "Trang sản phẩm hiển thị thất bại");
            System.out.println("Trang sản phẩm hiển thị thành công");

            // Step 5
            WebElement searchInput = driver.findElement(By.id("search_product"));
            searchInput.sendKeys("top");
            driver.findElement(By.id("submit_search")).click();
            System.out.println("Đã nhập từ khóa 'top' và nhấn nút tìm kiếm");

            // Step 6
            WebElement searchedProductsVisible = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertEquals(searchedProductsVisible.getText(), "SEARCHED PRODUCTS", "Kết quả tìm kiếm hiển thị thất bại");
            System.out.println("Kết quả tìm kiếm hiển thị thành công");

            // Step 7
            List<WebElement> searchedProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
            Assert.assertTrue(searchedProducts.size() > 0, "Không có sản phẩm nào hiển thị!");
            System.out.println("Số lượng sản phẩm tìm thấy: " + searchedProducts.size());

            // Step 8: Add those products to cart
            List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class='productinfo text-center']//a[contains(@class,'add-to-cart')]"));

            for (int i = 0; i < addToCartButtons.size(); i++) {
                js.executeScript("arguments[0].click();", addToCartButtons.get(i));
                WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
                continueBtn.click();
            }
            System.out.println("Đã thêm toàn bộ sản phẩm tìm được vào giỏ hàng");

            // Step 9
            WebElement cartBtn = driver.findElement(By.xpath("//a[contains(text(), 'Cart')]"));
            js.executeScript("arguments[0].click();", cartBtn);

            List<WebElement> cartItems = driver.findElements(By.xpath("//tbody/tr"));
            Assert.assertEquals(cartItems.size(), addToCartButtons.size(), "Số lượng sản phẩm trong giỏ không khớp với số lượng đã thêm.");
            System.out.println("Các sản phẩm đã hiển thị trong giỏ hàng thành công.");

            // Step 10
            driver.findElement(By.xpath("//a[@href='/login']")).click();
            driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dangquan1912@gmail.com");
            driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
            System.out.println("Đã đăng nhập thành công.");

            // Step 11
            WebElement cartBtnAfterLogin = driver.findElement(By.xpath("//a[contains(text(), 'Cart')]"));
            js.executeScript("arguments[0].click();", cartBtnAfterLogin);

            // Step 12
            List<WebElement> cartItemsAfterLogin = driver.findElements(By.xpath("//tbody/tr"));
            Assert.assertTrue(cartItemsAfterLogin.size() > 0, "Giỏ hàng trống sau khi đăng nhập!");
            Assert.assertEquals(cartItemsAfterLogin.size(), addToCartButtons.size(), "Số lượng sản phẩm bị mất sau khi đăng nhập.");
            System.out.println("Xác nhận sản phẩm vẫn nằm trong giỏ hàng sau khi đăng nhập!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test thất bại do Exception", e);
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình");
        }
    }
}