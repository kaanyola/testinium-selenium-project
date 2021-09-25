import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
    private WebDriver driver;
    private By priceInTheBasket = By.className("total-price");
    private By numberOfProducts = By.cssSelector("option[value='2']");
    private By totalProduct = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-of-type(1)");
    private By deleteProduct = By.cssSelector("a[title='Sil']");
    private By emptyBasket = By.cssSelector(".gg-w-22.gg-d-22.gg-t-21.gg-m-18>:nth-child(1)");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public String priceInTheBasket(){
        return driver.findElement(priceInTheBasket).getText();
    }

    public void setNumberOfProducts(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(numberOfProducts)).click();
    }

    public String getTotalProduct(){
        return driver.findElement(totalProduct).getText();
    }

    public void deleteProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(deleteProduct)).click();
    }

    public String isEmpty(){
        return driver.findElement(emptyBasket).getText();
    }
}
