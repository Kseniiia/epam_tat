package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;

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
        new MainPage(driver)
                .openPage()
                .openLoginForm()
                .login("xenia-2001@mail.ru", "12344321q")
                .waitForLoad();
    }

    @After
    public void stopBrowser() {
        driver.quit();
    }
}
