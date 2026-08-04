import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestCase24 {
    @Test
    public void main() {
        String downloadFilePath = System.getProperty("user.dir") + File.separator + "downloads";
        ChromeDriver driver = getChromeDriver(downloadFilePath);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.xpath("//div[@id='slider-carousel']")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị");
            System.out.println("Trang chủ hiển thị thành công.");

            // Step 4
            WebElement addToCartBtn = driver.findElement(By.xpath("//a[@data-product-id='1']"));
            js.executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
            js.executeScript("arguments[0].click();", addToCartBtn);
            System.out.println("Đã nhấn nút 'Add to cart' cho sản phẩm đầu tiên.");

            // Step 5
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            WebElement viewCartBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']"));
            viewCartBtn.click();

            // Step 6
            boolean isCartPageVisible = driver.findElement(By.xpath("//table[@id='cart_info_table']")).isDisplayed();
            Assert.assertTrue(isCartPageVisible, "Trang giỏ hàng không hiển thị");
            System.out.println("Trang giỏ hàng hiển thị thành công.");

            // Step 7
            WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            proceedToCheckoutBtn.click();
            System.out.println("Đã nhấn nút 'Proceed To Checkout' để tiến hành thanh toán.");

            // Step 8
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//a[@href='/login']")));
            WebElement loginBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/login']"));
            loginBtn.click();
            System.out.println("Đã nhấn nút 'Login' để đăng nhập.");

            // Step 9
            WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
            inputName.sendKeys("Dang Quan");
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            inputEmail.sendKeys("dangquan" + System.currentTimeMillis() + "@gmail.com");
            WebElement signUpBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signUpBtn.click();

            // Step 10
            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.id("password")).sendKeys("123456");
            driver.findElement(By.id("days")).sendKeys("19");
            driver.findElement(By.id("months")).sendKeys("12");
            driver.findElement(By.id("years")).sendKeys("2004");
            driver.findElement(By.id("first_name")).sendKeys("Dang");
            driver.findElement(By.id("last_name")).sendKeys("Quan");
            driver.findElement(By.id("company")).sendKeys("ABC Company");
            driver.findElement(By.id("address1")).sendKeys("123 Main St");
            driver.findElement(By.id("country")).sendKeys("United States");
            driver.findElement(By.id("state")).sendKeys("California");
            driver.findElement(By.id("city")).sendKeys("Los Angeles");
            driver.findElement(By.id("zipcode")).sendKeys("90001");
            driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
            js.executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
            createAccountBtn.click();
            System.out.println("Đã nhập thông tin và nhấn nút 'Create Account'.");

            WebElement homeBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            js.executeScript("arguments[0].click();", homeBtn);

            // Step 11
            boolean logInAsUserNameHeader = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
            Assert.assertTrue(logInAsUserNameHeader, "Không hiển thị logged in as username");
            System.out.println("Hiển thị logged in as username thành công.");

            // Step 12
            driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
            System.out.println("Đã nhấn nút 'View Cart'.");

            // Step 13
            driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
            System.out.println("Đã nhấn nút 'Proceed To Checkout' để tiến hành thanh toán.");

            // Step 14
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_delivery")));
            boolean isAddressDetailsVisible = driver.findElement(By.id("address_delivery")).isDisplayed();
            boolean isReviewOrderVisible = driver.findElement(By.id("cart_info")).isDisplayed();

            Assert.assertTrue(isAddressDetailsVisible, "Không hiển thị thông tin địa chỉ (Address Details)");
            Assert.assertTrue(isReviewOrderVisible, "Không hiển thị thông tin đơn hàng (Review Your Order)");
            System.out.println("Hiển thị thông tin địa chỉ và thông tin đơn hàng thành công.");

            // Step 15
            driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Vui lòng giao hàng vào buổi sáng.");
            driver.findElement(By.xpath("//a[@href='/payment']")).click();
            System.out.println("Đã nhấn nút 'Place Order' để tiến hành thanh toán.");

            // Step 16 and 17
            driver.findElement(By.name("name_on_card")).sendKeys("Dang Quan");
            driver.findElement(By.name("card_number")).sendKeys("1234567890123456");
            driver.findElement(By.name("cvc")).sendKeys("123");
            driver.findElement(By.name("expiry_month")).sendKeys("12");
            driver.findElement(By.name("expiry_year")).sendKeys("2024");

            WebElement submitBtn = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            js.executeScript("arguments[0].click();", submitBtn);
            System.out.println("Đã nhập thông tin thẻ và nhấn nút 'Pay and Confirm Order' để hoàn tất thanh toán.");

            // Step 18
            boolean successMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]")).isDisplayed();
            Assert.assertTrue(successMessage, "Thông báo đặt hàng không hiển thị");
            System.out.println("Thông báo đặt hàng hiển thị thành công.");

            // Step 19: Click Download Invoice (File sẽ tự tải xuống nhờ ChromeOptions setup bên trên)
            WebElement downloadInvoiceBtn = driver.findElement(By.xpath("//a[contains(@href, 'download_invoice')]"));
            downloadInvoiceBtn.click();
            System.out.println("Đã nhấn nút 'Download Invoice' để tải hóa đơn.");
            Thread.sleep(3000);

            // Step 20
            WebElement continueBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            js.executeScript("arguments[0].click();", continueBtn);
            System.out.println("Đã nhấn nút 'Continue' để tiếp tục.");

            // Step 21
            driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
            System.out.println("Đã nhấn nút 'Delete Account' để xóa tài khoản.");

            // Step 22
            boolean accountDeletedHeader = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed();
            Assert.assertTrue(accountDeletedHeader, "Thông báo xóa tài khoản không hiển thị");
            System.out.println("Thông báo xóa tài khoản hiển thị thành công.");

            WebElement continueBtn2 = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            js.executeScript("arguments[0].click();", continueBtn2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }

    private static ChromeDriver getChromeDriver(String downloadFilePath) {
        File downloadDir = new File(downloadFilePath);
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        chromePrefs.put("download.prompt_for_download", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }
}