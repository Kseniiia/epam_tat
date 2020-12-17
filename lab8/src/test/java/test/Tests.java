package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;
import page.PersonalAccountPage;

public class Tests {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        PersonalAccountPage accountPage = new MainPage(driver)
                .openPage()
                .openLoginForm()
                .login("xenia-2001@mail.ru", "12344321q")
                .waitForLoad()
                .account()
                .openPage();

        Assert.assertEquals(accountPage.getFullName(), "Мальчикова");
        Assert.assertEquals(accountPage.getEmail(), "xenia-2001@mail.ru");
    }

    @Test
    public void testSubscribe() {
        String result = new MainPage(driver)
                .openPage()
                .subscribe("abcd-10@test.com")
                .getSubscriptionPopupTitle();

        Assert.assertEquals(result, "Подписка оформлена");
    }

    @After
    public void stopBrowser() {
        driver.quit();
    }
}
