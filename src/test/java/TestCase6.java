import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase6 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");

            // Step 4
            WebElement contactUsBtn = driver.findElement(By.xpath("//a[@href='/contact_us']"));
            contactUsBtn.click();
            System.out.println("Đã nhấn nút Contact Us");

            // Step 5
            boolean iscontactUsHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'Get In Touch')]")).isDisplayed();
            Assert.assertTrue(iscontactUsHeaderVisible, "Form 'Get In Touch' không hiển thị.");
            System.out.println("Form 'Get In Touch' hiển thị thành công");

            // Step 6
            WebElement inputName = driver.findElement(By.xpath("//input[@data-qa='name']"));
            inputName.sendKeys("Anh Quan");
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='email']"));
            inputEmail.sendKeys("dangquan1912@gmail.com");
            WebElement inputSubject = driver.findElement(By.xpath("//input[@data-qa='subject']"));
            inputSubject.sendKeys("Test Subject");
            WebElement inputMessage = driver.findElement(By.xpath("//textarea[@data-qa='message']"));
            inputMessage.sendKeys("Test Message");

            // Step 7
            WebElement uploadFileBtn = driver.findElement(By.xpath("//input[@name='upload_file']"));
            uploadFileBtn.sendKeys("C:\\test.txt");
            System.out.println("Đã tải lên file test.txt");

            // Step 8
            WebElement submitBtn = driver.findElement(By.xpath("//input[@data-qa='submit-button']"));
            submitBtn.click();
            System.out.println("Đã nhấn nút Submit");

            // Step 9
            driver.switchTo().alert().accept();
            System.out.println("Đã chấp nhận alert");

            // Step 10
            boolean isSuccessMessageVisible = driver.findElement(By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]")).isDisplayed();
            Assert.assertTrue(isSuccessMessageVisible, "Thông báo 'Success! Your details have been submitted successfully.' không hiển thị.");
            System.out.println("Thông báo 'Success! Your details have been submitted successfully.' hiển thị thành công");

            // Step 11
            WebElement homeBtn = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
            homeBtn.click();
            System.out.println("Đã nhấn nút Home");
            WebElement isHomePageVisibleAfterClick = driver.findElement(By.id("slider-carousel"));
            Assert.assertTrue(isHomePageVisibleAfterClick.isDisplayed(), "Trang chủ không hiển thị sau khi nhấn nút Home.");
            System.out.println("Trang chủ hiển thị thành công sau khi nhấn nút Home");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
