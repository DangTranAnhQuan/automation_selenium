package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]");
    private By productList = By.xpath("//div[@class='product-image-wrapper']");
    private By firstProductViewBtn = By.xpath("//a[@href='/product_details/1']");
    private By searchInput = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private  By searchProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By productNameList = By.xpath("//div[@class='productinfo text-center']/p");
    private By firstProductAddToCartBtn = By.xpath("(//a[@data-product-id='1'])[1]");
    private By secondProductAddToCartBtn = By.xpath("(//a[@data-product-id='2'])[1]");
    private By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    private By viewCartModalBtn = By.xpath("//div[@class='modal-content']//a[@href='/view_cart']");
    private By brandsSidebar = By.xpath("//div[@class='brands_products']");
    private By poloBrandLink = By.xpath("//a[@href='/brand_products/Polo']");
    private By hmBrandLink = By.xpath("//a[@href='/brand_products/H&M']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kiểm tra Header 'ALL PRODUCTS' hiển thị")
    public boolean isAllProductsHeaderVisible() {
        return driver.findElement(allProductsHeader).isDisplayed();
    }

    @Step("Kiểm tra danh sách sản phẩm hiển thị")
    public boolean isProductListVisible() {
        return driver.findElement(productList).isDisplayed();
    }

    @Step("Nhấp vào nút 'View Product' của sản phẩm đầu tiên")
    public void clickViewFirstProduct() {
        WebElement viewProductBtn = driver.findElement(firstProductViewBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewProductBtn);
    }

    @Step("Nhập từ khóa '{keyword}' vào ô tìm kiếm và nhấn nút Search")
    public void searchProduct(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchBtn).click();
    }

    @Step("Kiểm tra Header 'SEARCHED PRODUCTS' hiển thị")
    public boolean isSearchedProductsHeaderVisible() {
        return driver.findElement(searchProductsHeader).isDisplayed();
    }

    @Step("Kiểm tra tất cả sản phẩm kết quả đều liên quan đến từ khóa '{keyword}'")
    public boolean areSearchedProductsRelatedToKeyword(String keyword) {
        List<WebElement> productsName = driver.findElements(productNameList);

        if (productsName.isEmpty()) {
            return false;
        }

        for (WebElement productName : productsName) {
            String name = productName.getText().toLowerCase();
            if (!name.contains(keyword.toLowerCase())) {
                System.out.println("Lỗi: Sản phẩm '" + name + "' không chứa từ khóa '" + keyword + "'");
                return false;
            }
        }
        return true;
    }

    @Step("Hover và click 'Add to cart' cho sản phẩm đầu tiên")
    public void addFirstProductToCart() {
        WebElement addBtn1 = driver.findElement(firstProductAddToCartBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn1);
    }

    @Step("Hover và click 'Add to cart' cho sản phẩm thứ hai")
    public void addSecondProductToCart() {
        WebElement addBtn2 = driver.findElement(secondProductAddToCartBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn2);
    }

    @Step("Click nút 'Continue Shopping' trên popup modal")
    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        continueBtn.click();
    }

    @Step("Click nút 'View Cart' trên popup modal")
    public void clickViewCartOnModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(viewCartModalBtn));
        viewCartBtn.click();
    }
    @Step("Kiểm tra danh sách Thương hiệu (Brands Sidebar) hiển thị")
    public boolean isBrandsSidebarVisible() {
        WebElement sidebar = driver.findElement(brandsSidebar);
        // Sử dụng JS Executor để cuộn tới phần tử theo mã gốc
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sidebar);
        return sidebar.isDisplayed();
    }

    @Step("Nhấp vào thương hiệu 'Polo'")
    public void clickPoloBrand() {
        WebElement poloLink = driver.findElement(poloBrandLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", poloLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", poloLink);
    }

    @Step("Nhấp vào thương hiệu 'H&M'")
    public void clickHMBrand() {
        WebElement hmLink = driver.findElement(hmBrandLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", hmLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hmLink);
    }
}