package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelegramPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://t.me/MileBy";

    @FindBy(xpath = "//div[@class='tgme_page_action']/a")
    private WebElement link;

    public TelegramPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public TelegramPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Telegram page is opened.");
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getAction() {
        return link.getAttribute("href");
    }

    public TelegramPage waitForLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.urlToBe(PAGE_URL));
        logger.info("Telegram page is loaded.");
        return this;
    }
}
