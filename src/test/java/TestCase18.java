import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase18 {
    @Test
    public void main() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        try{
            // Step 1 and 2
            driver.get("https://automationexercise.com/");
            System.out.println("Mở trang web thành công");

            // Step 3
            WebElement CategoryVisible = driver.findElement(By.xpath("//div[@id='accordian']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CategoryVisible);
            Assert.assertTrue(CategoryVisible.isDisplayed(), "Danh mục sản phẩm không hiển thị");
            System.out.println("Danh mục sản phẩm hiển thị thành công");

            // Step 4
            driver.findElement(By.xpath("//a[@href='#Women']")).click();
            System.out.println("Đã nhấn vào danh mục Women");

            // Step 5
            driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
            System.out.println("Đã nhấn vào danh mục Dress");

            // Step 6
            WebElement womanCategoryTitle = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertEquals(womanCategoryTitle.getText(), "WOMEN -  Dress PRODUCTS", "Sai tiêu đề danh mục!");

            // Step 7
            driver.findElement(By.xpath("//a[@href='#Men']")).click();
            System.out.println("Đã nhấn vào danh mục Men");
            driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();
            System.out.println("Đã nhấn vào danh mục T-shirt");

            // Step 8
            WebElement manCategoryTitle = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertEquals(manCategoryTitle.getText(), " Men -  Tshirts PRODUCTS", "Sai tiêu đề danh mục!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Đã kết thúc chương trình.");
        }
    }
}
