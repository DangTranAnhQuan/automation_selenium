import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestCase8 {
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
            WebElement productBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productBtn.click();
            System.out.println("Đã nhấn nút Products");

            // Step 5
            boolean isAllProductsHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed();
            if (isAllProductsHeaderVisible)
                System.out.println("Trang 'All Products' hiển thị thành công");
            else System.out.println("Trang 'All Products' không hiển thị");

            // Step 6
            WebElement productsList = driver.findElement(By.xpath("//div[@class='product-image-wrapper']"));
            if (productsList.isDisplayed())
                System.out.println("Danh sách sản phẩm hiển thị thành công");
            else System.out.println("Danh sách sản phẩm không hiển thị");

            // Step 7
            WebElement viewProductBtn = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
            viewProductBtn.click();
            System.out.println("Đã nhấn nút View Product");

            // Step 8
            boolean isProductDetailsHeaderVisible = driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]")).isDisplayed();
            if (isProductDetailsHeaderVisible)
                System.out.println("Trang 'Product Details' hiển thị thành công");
            else System.out.println("Trang 'Product Details' không hiển thị");

            // Step 9
            WebElement productDetails = driver.findElement(By.xpath("//div[@class='product-information']"));
            if (productDetails.isDisplayed())
                System.out.println("Chi tiết sản phẩm hiển thị thành công");
            else System.out.println("Chi tiết sản phẩm không hiển thị");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
