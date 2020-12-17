package test;

import driver.DriverSingleton;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import page.CatalogPage;
import page.MainPage;
import service.UserCreator;
import util.TestListener;

@Listeners({TestListener.class})
public class Tests {
    private WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void testLogin() {
        User user = UserCreator.withCredentialsFromProperty();
        new MainPage(driver)
                .openPage()
                .openLoginForm()
                .login(user)
                .waitForLoad();
    }

    @Test
    public void testSubscribe() {
        User user = UserCreator.withEmail();
        new MainPage(driver)
                .openPage()
                .subscribe(user)
                .waitForSuccessfullSubscriptionPopup();
    }

    @Test
    public void testRegister() {
        User user = UserCreator.withFullName();
        new MainPage(driver)
                .openPage()
                .redirectToRegistrationPage()
                .waitForLoad()
                .register(user)
                .waitForLoad();
    }

    @Test
    public void testAddToCart() {
        String catalogArticleNumber = "1448341";

        String cartArticleNumber = new CatalogPage(driver)
                .openPage()
                .addToCart(catalogArticleNumber)
                .redirectToCart()
                .waitForLoad()
                .getFirstItemArticleNumber();

        assertThat(catalogArticleNumber, is(equalTo(cartArticleNumber)));
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
