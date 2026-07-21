import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestCase14 {
    public void main(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ hiển thị thất bại");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement addCartBtn = driver.findElement(By.xpath("//a[@data-product-id='1']"));
            addCartBtn.click();
            System.out.println("Đã nhấn nút thêm sản phẩm vào giỏ hàng");

            // Step 5
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']")));
            WebElement cartBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']"));
            cartBtn.click();
            System.out.println("Đã nhấn nút View Cart");

            // Step 6
            boolean isCartPageVisible = driver.findElement(By.id("cart_info")).isDisplayed();
            Assert.assertTrue(isCartPageVisible, "Trang giỏ hàng hiển thị thất bại");
            System.out.println("Trang giỏ hàng hiển thị thành công");

            // Step 7
            WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            proceedToCheckoutBtn.click();
            System.out.println("Đã nhấn nút Proceed To Checkout");

            // Step 8
            WebElement loginBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/login']"));
            loginBtn.click();
            System.out.println("Đã nhấn nút Login");

            // Step 9
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

            // Step 10
            boolean isAccountCreatedVisible = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).isDisplayed();
            Assert.assertTrue(isAccountCreatedVisible, "Thông báo 'Account Created!' không hiển thị.");
            System.out.println("Thông báo 'Account Created!' hiển thị thành công");
            WebElement continueBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
            continueBtn.click();
            System.out.println("Đã nhấn nút Continue");

            // Step 11
            boolean loggedAsUserName = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
            Assert.assertTrue(loggedAsUserName, "Header 'Logged in as' không hiển thị.");
            System.out.println("Header 'Logged in as' hiển thị thành công");

            // Step 12
            WebElement cartBtnAfterLogin = driver.findElement(By.xpath("//a[@href='/view_cart']"));
            cartBtnAfterLogin.click();
            System.out.println("Đã nhấn nút View Cart sau khi đăng nhập");

            // Step 13
            WebElement proceedCheckoutBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            proceedCheckoutBtn.click();
            System.out.println("Đã nhấn nút Proceed To Checkout sau khi đăng nhập");

            // Step 14
            boolean isAddressDetailsVisible = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed();
            Assert.assertTrue(isAddressDetailsVisible, "Thông tin địa chỉ không hiển thị.");
            System.out.println("Thông tin địa chỉ hiển thị thành công");
            boolean reviewOrder = driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed();
            Assert.assertTrue(reviewOrder, "Review Order không hiển thị.");
            System.out.println("Review Order hiển thị thành công");

            // Step 15
            WebElement inputDescription = driver.findElement(By.xpath("//textarea[@name='message']"));
            inputDescription.sendKeys("Vui lòng giao hàng vào buổi sáng.");
            WebElement placeOrderBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            placeOrderBtn.click();
            System.out.println("Đã nhấn nút Place Order");

            // Step 16
            WebElement nameOnCardInput = driver.findElement(By.name("name_on_card"));
            nameOnCardInput.sendKeys("Dang Quan");
            WebElement cardNumberInput = driver.findElement(By.name("card_number"));
            cardNumberInput.sendKeys("1234567890123456");
            WebElement cvcInput = driver.findElement(By.name("cvc"));
            cvcInput.sendKeys("123");
            WebElement expiryMonthInput = driver.findElement(By.name("expiry_month"));
            expiryMonthInput.sendKeys("12");
            WebElement expiryYearInput = driver.findElement(By.name("expiry_year"));
            expiryYearInput.sendKeys("2024");

            // Step 17
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            WebElement payAndConfirmBtn = driver.findElement(By.id("submit"));
            payAndConfirmBtn.click();
            System.out.println("Đã nhập thông tin thẻ và nhấn nút Pay and Confirm Order");

            // Step 18
            WebElement successPlaceOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]")));
            Assert.assertTrue(successPlaceOrder.isDisplayed(), "Thông báo 'Congratulations! Your order has been confirmed!' không hiển thị.");
            System.out.println("Thông báo 'Congratulations! Your order has been confirmed!' hiển thị thành công");

            // Step 19
            WebElement deleteBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
            deleteBtn.click();
            System.out.println("Đã nhấn nút Delete Account");

            // Step 20
            boolean isAccountDeleted = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed();
            Assert.assertTrue(isAccountDeleted, "Thông báo 'Account Deleted!' không hiển thị.");
            System.out.println("Thông báo 'Account Deleted!' hiển thị thành công");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
