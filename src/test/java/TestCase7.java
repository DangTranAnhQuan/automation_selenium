import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TestCase7 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
 
        WebDriver driver = new ChromeDriver(options);
 
        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");
 
            // Step 3
            boolean isHomePageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            Assert.assertTrue(isHomePageVisible, "Trang chủ không hiển thị.");
            System.out.println("Trang chủ hiển thị thành công");
 
            // Step 4
            WebElement testcaseBtn = driver.findElement(By.xpath("//a[@href='/test_cases']"));
            testcaseBtn.click();
            System.out.println("Đã nhấn nút Test Cases");
 
            // Step 5
            boolean isTestcaseHeaderVisible = driver.findElement(By.xpath("//b[contains(text(),'Test Cases')]")).isDisplayed();
            Assert.assertTrue(isTestcaseHeaderVisible, "Trang 'Test Cases' không hiển thị.");
            System.out.println("Trang 'Test Cases' hiển thị thành công");
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
