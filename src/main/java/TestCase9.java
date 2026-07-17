import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class TestCase9 {
    public static void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            boolean isHomepageVisible = driver.findElement(By.id("slider-carousel")).isDisplayed();
            if (isHomepageVisible)
                System.out.println("Trang chủ hiển thị thành công");
            else System.out.println("Trang chủ không hiển thị");

            // Step 4
            WebElement productBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productBtn.click();
            System.out.println("Đã nhấn nút Products");

            // Step 5
            boolean isProductPageVisible = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed();
            if (isProductPageVisible)
                System.out.println("Trang All Products hiển thị thành công");
            else System.out.println("Trang All Products không hiển thị");

            // Step 6
            WebElement searchInput = driver.findElement(By.id("search_product"));
            searchInput.sendKeys("top");
            WebElement searchBtn = driver.findElement(By.id("submit_search"));
            searchBtn.click();
            System.out.println("Đã tìm kiếm sản phẩm");

            // Step 7
            boolean isSearchPageVisible = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).isDisplayed();
            if (isSearchPageVisible)
                System.out.println("Trang Searched Products hiển thị thành công");
            else System.out.println("Trang Searched Products không hiển thị");

            // Step 8
            List<WebElement> productsName = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
            if (productsName.isEmpty())
                System.out.println("Không tìm thấy sản phẩm nào");
            String key = "top";
            boolean check = true;
            for (WebElement productName : productsName){
                String name = productName.getText().toLowerCase();
                if (name.contains(key)){
                    System.out.println("Tên sản phẩm: " + name + " chứa từ khóa tìm kiếm: " + key);
                } else {
                    System.out.println("Tên sản phẩm: " + name + " không chứa từ khóa tìm kiếm: " + key);
                    check = false;
                }
            }

            if (check)
                System.out.println("Tất cả sản phẩm đều chứa từ khóa tìm kiếm: " + key);
            else
                System.out.println("Có sản phẩm không chứa từ khóa tìm kiếm: " + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thoát trình duyệt");
            driver.quit();
        }
    }
}
