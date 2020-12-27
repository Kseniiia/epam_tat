package test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverFactory.create();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        driver.quit();
        driver = null;
    }
}