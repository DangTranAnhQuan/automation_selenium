import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase23 {
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
        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.xpath("//div[@id='slider-carousel']")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ hiển thị thất bại");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            driver.findElement(By.xpath("//a[@href='/login']")).click();

            // Step 5
            WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
            inputName.sendKeys("Dang Quan");
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            inputEmail.sendKeys("dangquan1912@gmail.com");
            WebElement signUpBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signUpBtn.click();
            System.out.println("Đã nhập thông tin và nhấn nút SignUp");

            WebElement genderRadio = driver.findElement(By.id("id_gender1"));
            genderRadio.click();
            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("123456");
            Select daysSelect = new Select(driver.findElement(By.id("days")));
            daysSelect.selectByValue("19");
            Select monthsSelect = new Select(driver.findElement(By.id("months")));
            monthsSelect.selectByValue("12");
            Select yearsSelect = new Select(driver.findElement(By.id("years")));
            yearsSelect.selectByValue("2004");
            WebElement firstNameInput = driver.findElement(By.id("first_name"));
            firstNameInput.sendKeys("Dang");
            WebElement lastNameInput = driver.findElement(By.id("last_name"));
            lastNameInput.sendKeys("Quan");
            WebElement addressInput = driver.findElement(By.id("address1"));
            addressInput.sendKeys("123 Main St");
            Select countrySelect = new Select(driver.findElement(By.id("country")));
            countrySelect.selectByVisibleText("United States");
            WebElement stateInput = driver.findElement(By.id("state"));
            stateInput.sendKeys("California");
            WebElement cityInput = driver.findElement(By.id("city"));
            cityInput.sendKeys("Los Angeles");
            WebElement zipCodeInput = driver.findElement(By.id("zipcode"));
            zipCodeInput.sendKeys("90001");
            WebElement mobileNumberInput = driver.findElement(By.id("mobile_number"));
            mobileNumberInput.sendKeys("1234567890");
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
            createAccountBtn.click();
            System.out.println("Đã nhập thông tin và nhấn nút Create Account");

            // Step 6
            boolean isAccountCreateHeader = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).isDisplayed();
            Assert.assertTrue(isAccountCreateHeader, "Thông báo 'Account Created!' không hiển thị.");
            System.out.println("Thông báo 'Account Created!' hiển thị thành công");
            WebElement continueBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            continueBtn.click();
            System.out.println("Đã nhấn nút Continue");

            // Step 7
            boolean isLoggedInHeader = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
            Assert.assertTrue(isLoggedInHeader, "Thông báo 'Logged in as' không hiển thị.");
            System.out.println("Thông báo 'Logged in as' hiển thị thành công");

            // Step 8
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']")));
            WebElement addProductToCart = driver.findElement(By.xpath("//a[@data-product-id='1']"));

            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addProductToCart);

            js.executeScript("arguments[0].click();", addProductToCart);
            System.out.println("Đã nhấn nút Add to cart cho sản phẩm đầu tiên bằng JS");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            // Step 9
            WebElement cartBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']"));
            cartBtn.click();
            System.out.println("Đã nhấn nút Cart trong modal");

            // Step 10
            boolean isCartPageVisible = driver.findElement(By.id("cart_info")).isDisplayed();
            Assert.assertTrue(isCartPageVisible, "Trang giỏ hàng không hiển thị.");
            System.out.println("Trang giỏ hàng hiển thị thành công");

            // Step 11
            WebElement proceedBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            proceedBtn.click();
            System.out.println("Đã nhấn nút Proceed To Checkout");

            // Step 12: 12. Verify that the delivery address is same address filled at the time registration of account
            WebElement deliveryAddress = driver.findElement(By.xpath("//ul[@id='address_delivery']"));
            String deliveryAddressText = deliveryAddress.getText();
            Assert.assertTrue(deliveryAddressText.contains("Dang Quan"), "Tên không khớp với địa chỉ giao hàng.");
            Assert.assertTrue(deliveryAddressText.contains("123 Main St"), "Địa chỉ không khớp với địa chỉ giao hàng.");
            Assert.assertTrue(deliveryAddressText.contains("Los Angeles"), "Thành phố không khớp với địa chỉ giao hàng.");
            Assert.assertTrue(deliveryAddressText.contains("California"), "Bang không khớp với địa chỉ giao hàng.");
            Assert.assertTrue(deliveryAddressText.contains("90001"), "Mã zip không khớp với địa chỉ giao hàng.");
            Assert.assertTrue(deliveryAddressText.contains("United States"), "Quốc gia không khớp với địa chỉ giao hàng.");
            System.out.println("Địa chỉ giao hàng khớp với thông tin đã đăng ký.");

            // Step 13
            WebElement billingAddress = driver.findElement(By.xpath("//ul[@id='address_invoice']"));
            String billingAddressText = billingAddress.getText();
            Assert.assertTrue(billingAddressText.contains("Dang Quan"), "Tên không khớp với địa chỉ thanh toán.");
            Assert.assertTrue(billingAddressText.contains("123 Main St"), "Đường không khớp với địa chỉ thanh toán.");
            Assert.assertTrue(billingAddressText.contains("Los Angeles"), "Thành phố không khớp với địa chỉ thanh toán.");
            Assert.assertTrue(billingAddressText.contains("California"), "Bang không khớp với địa chỉ thanh toán.");
            Assert.assertTrue(billingAddressText.contains("90001"), "Mã zip không khớp với địa chỉ thanh toán.");
            Assert.assertTrue(billingAddressText.contains("United States"), "Quốc gia không khớp với địa chỉ thanh toán.");
            System.out.println("Địa chỉ thanh toán khớp với thông tin đã đăng ký.");

            // Step 14
            WebElement deleteBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
            deleteBtn.click();
            System.out.println("Đã nhấn nút Delete Account");

            // Step 15
            boolean isAccountDeleteHeader = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed();
            Assert.assertTrue(isAccountDeleteHeader, "Thông báo 'Account Deleted!' không hiển thị.");
            System.out.println("Thông báo 'Account Deleted!' hiển thị thành công");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
