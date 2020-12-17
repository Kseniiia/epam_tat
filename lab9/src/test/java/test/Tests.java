package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.MainPage;
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
        new MainPage(driver)
                .openPage()
                .openLoginForm()
                .login("xenia-2001@mail.ru", "12344321q")
                .waitForLoad();
    }

    @Test
    public void testSubscribe() {
        new MainPage(driver)
                .openPage()
                .subscribe("abcd@test.com")
                .waitForSuccessfullSubscriptionPopup();
    }

    @Test
    public void testRegister() {
        new MainPage(driver)
                .openPage()
                .redirectToRegistrationPage()
                .waitForLoad()
                .register("Ivanov Ivan", "abcd@test.com", "123123q", "123123q")
                .waitForLoad();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
