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

public class TestCase15 {
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
            Assert.assertTrue(isHomePageVisible, "Trang chủ hiển thị thất bại");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement signUpAndloginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            signUpAndloginBtn.click();
            System.out.println("Đã nhấn nút Login");

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
            boolean isLoggedInAsVisible = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
            Assert.assertTrue(isLoggedInAsVisible, "Header 'Logged in as' không hiển thị.");
            System.out.println("Header 'Logged in as' hiển thị thành công");

            // Step 8
            WebElement addProductToCart = driver.findElement(By.xpath("//a[@data-product-id='1']"));
            addProductToCart.click();
            System.out.println("Đã nhấn nút Add to cart cho sản phẩm đầu tiên");

            // Step 9
            WebElement cartBtn = driver.findElement(By.xpath("//a[@href='/view_cart']"));
            cartBtn.click();
            System.out.println("Đã nhấn nút Cart");

            // Step 10
            boolean isCartPageVisible = driver.findElement(By.id("cart_info")).isDisplayed();
            Assert.assertTrue(isCartPageVisible, "Trang giỏ hàng không hiển thị.");
            System.out.println("Trang giỏ hàng hiển thị thành công");

            // Step 11
            WebElement proceedBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            proceedBtn.click();
            System.out.println("Đã nhấn nút Proceed To Checkout");

            // Step 12
            boolean isAddressDetailsVisible = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed();
            Assert.assertTrue(isAddressDetailsVisible, "Thông tin địa chỉ không hiển thị.");
            System.out.println("Thông tin địa chỉ hiển thị thành công");
            boolean isReviewOrderHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed();
            Assert.assertTrue(isReviewOrderHeaderVisible, "Review Order không hiển thị.");
            System.out.println("Review Order hiển thị thành công");

            // Step 13
            WebElement inputDescription = driver.findElement(By.xpath("//textarea[@name='message']"));
            inputDescription.sendKeys("Vui lòng giao hàng vào buổi sáng.");
            WebElement placeOrderBtn = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
            placeOrderBtn.click();
            System.out.println("Đã nhập mô tả và nhấn nút Place Order");

            // Step 14
            WebElement nameOnCard = driver.findElement(By.name("name_on_card"));
            nameOnCard.sendKeys("Dang Quan");
            WebElement cardNumber = driver.findElement(By.name("card_number"));
            cardNumber.sendKeys("1234567890123456");
            WebElement cvc = driver.findElement(By.name("cvc"));
            cvc.sendKeys("123");
            WebElement expiryMonth = driver.findElement(By.name("expiry_month"));
            expiryMonth.sendKeys("12");
            WebElement expiryYear = driver.findElement(By.name("expiry_year"));
            expiryYear.sendKeys("2024");

            // Step 15
            WebElement payAndConfirmOrderBtn = driver.findElement(By.id("submit"));
            payAndConfirmOrderBtn.click();
            System.out.println("Đã nhập thông tin thẻ và nhấn nút Pay and Confirm Order");

            // Step 16
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]")));
            Assert.assertTrue(successMessage.isDisplayed(), "Thông báo 'Congratulations! Your order has been confirmed!' không hiển thị.");
            System.out.println("Thông báo 'Congratulations! Your order has been placed confirmed!' hiển thị thành công");

            // Step 17
            WebElement deleteBtn = driver.findElement(By.xpath("//a[@href='/delete_account']"));
            deleteBtn.click();
            System.out.println("Đã nhấn nút Delete Account");

            // Step 18
            boolean isAccountDeleteHeader = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed();
            Assert.assertTrue(isAccountDeleteHeader, "Thông báo 'Account Deleted!' không hiển thị.");
            System.out.println("Thông báo 'Account Deleted!' hiển thị thành công");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
