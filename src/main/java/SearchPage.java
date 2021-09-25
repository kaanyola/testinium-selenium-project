import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductDetailPage goToProductDetails(){
        Random random = new Random();
        int rand = random.nextInt(48) + 1;
        By randomElement = By.cssSelector(".products-container>li:nth-of-type(" + rand + ")");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(randomElement)).click();
        return new ProductDetailPage(driver);
    }
}
