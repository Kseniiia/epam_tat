package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://mile.by/personal/";

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public PersonalPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Personal page is opened.");
        return this;
    }

    public PersonalAccountPage goToAccountPage() {
        return new PersonalAccountPage(driver);
    }

    public PersonalPage waitForLoad() {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return driver.getCurrentUrl().equals(PAGE_URL);
        };
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(expectation);
        logger.info("Personal page is loaded.");
        return this;
    }
}
