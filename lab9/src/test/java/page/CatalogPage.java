package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends AbstractPage {
    private final String PAGE_URL = "https://mile.by/catalog/tekhnika-dlia-kukhni-/";

    @FindBy(xpath = "//div[contains(@class, 'city-ip-popup')]/following-sibling::div")
    private WebElement closeCityPopupButton;

    @FindBy(xpath = "//div[contains(@class, 'add-cart-form-popup')]")
    private WebElement redirectToCartPopup;

    @FindBy(xpath = "//div[contains(@class, 'add-cart-form-popup')]/div[2]/a")
    private WebElement redirectToCartButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CatalogPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CatalogPage addToCart(String articleNumber) {
        closeCityPopupButton.click();

        By locator = By.xpath("//div[@class='anons-sku'][contains(text(), '" + articleNumber + "')]/parent::div//button[@class='element-atb']");
        WebElement addToCartButton = driver.findElement(locator);

        addToCartButton.click();
        return this;
    }

    public CartPage redirectToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(redirectToCartPopup));

        redirectToCartButton.click();
        return new CartPage(driver);
    }

    public CatalogPage waitForLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals(PAGE_URL);
            }
        };

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(expectation);
        return this;
    }
}
