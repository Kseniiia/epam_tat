package page;

import model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://mile.by/cart/";

    @FindBy(xpath = "//form[@class='table-basket-item'][1]/div[2]/div[@class='product-name']/p")
    private WebElement firstItemNumber;

    @FindBy(xpath = "//form[@class='table-basket-item'][1]/div[2]/div[@class='product-name']/a/p")
    private WebElement firstItemName;

    @FindBy(xpath = "//form[@class='table-basket-item'][1]/div[3]/p[@class='price']")
    private WebElement firstItemPrice;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CartPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Cart page is opened.");
        return this;
    }

    public Item getFirstItem() {
        String number = firstItemNumber.getText().substring(5);
        String name = firstItemName.getText();
        Double price = Double.parseDouble(firstItemPrice.getText());
        return new Item(number, name, price);
    }

    public CartPage waitForLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals(PAGE_URL);
            }
        };
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(expectation);
        logger.info("Cart page is loaded.");
        return this;
    }
}
