package test;

import driver.DriverSingleton;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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
        new CatalogPage(driver)
                .openPage()
                .addToCart("1448341")
                .redirectToCart();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
