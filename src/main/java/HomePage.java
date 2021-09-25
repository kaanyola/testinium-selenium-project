import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    By loginOrRegisterButton = By.cssSelector("div[data-cy='header-user-menu']");
    By mainBy = By.className("f2lc5a-0");
    By closeCookiesButtonBy = By.className("tyj39b-3.fEwnjq");
    By searchBoxBy = By.className("sc-4995aq-0");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHesapText(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginOrRegisterButton)).getText();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainBy));
    }

    public SearchPage search(String word){
        driver.findElement(searchBoxBy).sendKeys(word + Keys.ENTER);
        return new SearchPage(driver);
    }
}
