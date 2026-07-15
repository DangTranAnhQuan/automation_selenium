import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestCase4 {
    public static void main() {
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
            if (isHomePageVisible)
                System.out.println("Trang chủ hiển thị thành công");
            else System.out.println("Trang chủ không hiển thị");

            // Step 4
            WebElement signUpBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            signUpBtn.click();
            System.out.println("Đã nhấn nút SignUp/Login");

            // Step 5
            boolean isLoginHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]")).isDisplayed();
            if (isLoginHeaderVisible)
                System.out.println("Form Login hiển thị thành công");
            else System.out.println("Form Login không hiển thị");

            //Step 6
            WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            inputEmail.sendKeys("dangquan1912@gmail.com");
            WebElement inputPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
            inputPassword.sendKeys("123456");

            // Step 7
            WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
            loginBtn.click();
            System.out.println("Đã nhấn nút Login");

            // Step 8
            boolean loggedInAsUserNameVisible = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
            if (loggedInAsUserNameVisible)
                System.out.println("Trang 'Logged in as' hiển thị thành công");
            else System.out.println("Trang 'Logged in as' không hiển thị");

            //Step 9
            WebElement logoutBtn = driver.findElement(By.xpath("//a[@href='/logout']"));
            logoutBtn.click();
            System.out.println("Đã nhấn nút logout");

            //Step 10
            boolean isLoginPageAfterLogout = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed();
            if (isLoginPageAfterLogout)
                System.out.println("Trang 'Login to your account' hiển thị thành công sau khi logout");
            else System.out.println("Trang 'Login to your account' không hiển thị sau khi logout");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Đang đóng trình duyệt...");
            driver.quit();
        }

    }
}
