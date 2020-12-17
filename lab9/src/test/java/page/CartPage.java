package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final String PAGE_URL = "https://mile.by/cart/";

    @FindBy(xpath = "//form[@class='table-basket-item'][1]/div[2]/div/p")
    private WebElement firstItemArticleNumber;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CartPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getFirstItemArticleNumber() {
        return firstItemArticleNumber.getText().substring(5);
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
