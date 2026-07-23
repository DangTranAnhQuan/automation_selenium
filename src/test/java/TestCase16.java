import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestCase16 {
    public void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--incognito");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Home page is not visible.");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            driver.findElement(By.xpath("//a[@href='/login']")).click();
            System.out.println("Đã nhấn nút Login");

            // Step 5
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-email']"))).sendKeys("dangquan1912@gmail.com");
            driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

            // Step 6
            WebElement logInHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));
            Assert.assertTrue(logInHeader.isDisplayed(), "Đăng nhập không thành công");
            System.out.println("Đăng nhập thành công");

            // Step 7
            WebElement addToCartBtn = driver.findElement(By.xpath("//a[@data-product-id='1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
            System.out.println("Đã nhấn nút Add to cart");

            // Step 8
            WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']")));
            viewCartBtn.click();
            System.out.println("Đã nhấn nút View Cart");

            // Step 9
            WebElement cartInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_info")));
            Assert.assertTrue(cartInfo.isDisplayed(), "Trang giỏ hàng không hiển thị");
            System.out.println("Trang giỏ hàng hiển thị thành công");

            // Step 10
            WebElement proceedBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceedBtn);
            wait.until(ExpectedConditions.elementToBeClickable(proceedBtn)).click();
            System.out.println("Đã nhấn nút Proceed To Checkout");

            // Step 11
            WebElement addressDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Address Details')]")));
            Assert.assertTrue(addressDetails.isDisplayed(), "Thông tin địa chỉ không hiển thị");
            System.out.println("Thông tin địa chỉ hiển thị thành công");
            WebElement reviewOrder = driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]"));
            Assert.assertTrue(reviewOrder.isDisplayed(), "Thông tin đơn hàng không hiển thị");
            System.out.println("Thông tin đơn hàng hiển thị thành công");

            // Step 12
            driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Đây là ghi chú cho đơn hàng.");
            driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
            System.out.println("Đã nhập ghi chú và nhấn nút Place Order");

            // Step 13
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card"))).sendKeys("Dang Quan");
            driver.findElement(By.name("card_number")).sendKeys("1234567890123456");
            driver.findElement(By.name("cvc")).sendKeys("123");
            driver.findElement(By.name("expiry_month")).sendKeys("12");
            driver.findElement(By.name("expiry_year")).sendKeys("2024");

            // Step 14
            WebElement payBtn = driver.findElement(By.id("submit"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payBtn);
            wait.until(ExpectedConditions.elementToBeClickable(payBtn)).click();
            System.out.println("Đã nhập thông tin thẻ và nhấn nút Pay and Confirm Order");

            // Step 15
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]")));
            Assert.assertTrue(successMessage.isDisplayed(), "Thông báo đặt hàng không hiển thị");
            System.out.println("Thông báo đặt hàng hiển thị thành công");

            // Step 16
            driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
            System.out.println("Đã nhấn nút Delete Account");

            // Step 17
            boolean accountDeletedHeader = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed();
            Assert.assertTrue(accountDeletedHeader, "Thông báo xóa tài khoản không hiển thị");
            System.out.println("Thông báo xóa tài khoản hiển thị thành công");
            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
            System.out.println("Đã nhấn nút Continue");


        } catch (TimeoutException e) {
            System.err.println("Lỗi: Một phần tử không được tìm thấy hoặc không hiển thị trong thời gian chờ.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Đóng trình duyệt");
            driver.quit();
        }
    }
}