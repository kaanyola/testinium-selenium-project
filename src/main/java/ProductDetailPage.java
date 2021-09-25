import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
    private WebDriver driver;
    private By lowProductPrice  = By.id("sp-price-lowPrice");
    private By highProductPrice = By.id("sp-price-highPrice");
    private By addToBasketButton = By.id("add-to-basket");
    private By goToBasketButton = By.className("robot-header-iconContainer-cart");
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String productPrice(){
        String productPrice = driver.findElement(lowProductPrice).getText();
        if (productPrice.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(highProductPrice)).getText();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lowProductPrice)).getText();
    }

    public void addToBasket(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketButton)).click();
    }

    public BasketPage goToBasket(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(goToBasketButton)).click();
        return new BasketPage(driver);
    }
}
