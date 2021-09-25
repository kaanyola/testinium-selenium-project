import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GittiGidiyorPage {

    private WebDriver driver;
    private final By userName = By.id("L-UserNameField");
    private final By password = By.id("L-PasswordField");
    private final By girisYap = By.cssSelector(".gekhq4-6[title='Giriş Yap']");
    private final By girisYapButon = By.cssSelector("a[data-cy='header-login-button']");


    public GittiGidiyorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGirisYap(){
        WebElement girisYapElement = driver.findElement(girisYap);
        Actions actionProvider = new Actions(driver);
        // Performs mouse move action onto the element
        actionProvider.moveToElement(girisYapElement).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(girisYapButon)).click();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        /*WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-3wdx43-0")));
        myDynamicElement.click();*/
    }

    public void setUsername(){}

    public void setPassword(){}
}
