package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final String PAGE_URL = "https://mile.by/cart/";

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CartPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CartPage waitForLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals(PAGE_URL);
            }
        };

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(expectation);
        return this;
    }
}
