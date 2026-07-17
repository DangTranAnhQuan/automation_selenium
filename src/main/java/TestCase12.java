import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class TestCase12 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công ");

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
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement addToCartBtn = driver.findElement(By.xpath("//a[@data-product-id='1'][1]"));
            js.executeScript("arguments[0].scrollIntoView(true);",addToCartBtn);
            js.executeScript("arguments[0].click();", addToCartBtn);
            System.out.println("Đã nhấn nút Add to cart");

            // Step 6
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement continueShoppingBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue Shopping')]")));
            continueShoppingBtn.click();
            System.out.println("Đã nhấn nút Continue Shopping");

            // Step 7
            WebElement addToCartBtn2 = driver.findElement(By.xpath("//a[@data-product-id='2']"));
            addToCartBtn2.click();
            System.out.println("Đã nhấn nút Add to cart cho sản phẩm thứ 2");

            // Step 8
            WebElement viewCartBtn = driver.findElement(By.xpath("//a[@href='/view_cart'][1]"));
            js.executeScript("arguments[0].click();", viewCartBtn);
            System.out.println("Đã nhấn nút View Cart");

            // Step 9
            Integer cartItemsCount = driver.findElements(By.xpath("//tr[@id='product-1' or @id='product-2']")).size();
            if (cartItemsCount == 2)
                System.out.println("Hai sản phẩm đã được thêm vào giỏ hàng thành công");
            else System.out.println("Số lượng sản phẩm trong giỏ hàng không đúng");

            // Step 10
            List<WebElement> cartItems = driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr"));
            for (int i = 0; i < cartItems.size(); i++) {
                WebElement item = cartItems.get(i);
                String price = item.findElement(By.xpath(".//td[@class='cart_price']/p")).getText();
                String quantity = item.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText();
                String total = item.findElement(By.xpath(".//td[@class='cart_total']/p")).getText();
                System.out.println("Sản phẩm " + (i + 1) + ": Giá = " + price + ", Số lượng = " + quantity + ", Tổng = " + total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
