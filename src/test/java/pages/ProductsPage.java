package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}