import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GittiGidiyorTest extends BaseTest{


    @Test
    public void gittiGidiyorTest(){
        //değişkenlerimi tanımladım kontrol için
        String title = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String email = "testkaanyola@gmail.com";
        String password = "testkaan1";

        driver.manage().window().maximize();
        String realTitle = driver.getTitle();
        //bulunduğum sayfayı kontrol
        Assertions.assertEquals(realTitle, title);
        GittiGidiyorPage gittiGidiyorPage = new GittiGidiyorPage(driver);
        //login page'e gidiyor
        gittiGidiyorPage.clickGirisYap();

        LoginPage loginPage = new LoginPage(driver);
        //email ve password girme işlemi
        loginPage.login(email, password);

        HomePage homePage = new HomePage(driver);
        String hesapButonText = homePage.getHesapText();
        //home pagede olup olmadığını kontrol
        Assertions.assertTrue(hesapButonText.contains("Hesabım"));

        SearchPage searchPage = homePage.search("bilgisayar");
        driver.get(driver.getCurrentUrl() + "&sf=" + 2);
        //ikinci sayfada olup olmadığını kontrol
        Assertions.assertTrue(driver.getCurrentUrl().contains("2"));

        ProductDetailPage productDetailsPage = searchPage.goToProductDetails();
        String productPrice = productDetailsPage.productPrice();
        productDetailsPage.addToBasket();

        BasketPage basketPage = productDetailsPage.goToBasket();
        //sepetteki fiyatı kontrol
        Assertions.assertEquals(productPrice, basketPage.priceInTheBasket());
        basketPage.setNumberOfProducts();
        //sepetteki ürün adedini kontrol
        Assertions.assertTrue(basketPage.getTotalProduct().contains("2 Adet"));

        basketPage.deleteProduct();
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        //sepetin boş olup olmadığını kontrol
        Assertions.assertEquals(basketMessage, basketPage.isEmpty());

    }
}
