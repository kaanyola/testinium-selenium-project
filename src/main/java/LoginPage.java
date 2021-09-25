import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    By userNameField = By.id("L-UserNameField");
    By passwordField = By.id("L-PasswordField");
    By loginButton = By.id("gg-login-enter");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String email, String password){
        driver.findElement(userNameField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        WebElement loginElement = driver.findElement(loginButton);
        Actions actionProvider = new Actions(driver);
        // Performs mouse move action onto the element
        actionProvider.moveToElement(loginElement).build().perform();
        loginElement.click();

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoad();
        return homePage;
    }
}
