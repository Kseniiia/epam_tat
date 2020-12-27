package page;

import model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://mile.by/catalog/tekhnika-dlia-kukhni-/";

    @FindBy(xpath = "//div[contains(@class, 'city-ip-popup')]/following-sibling::div")
    private WebElement closeCityPopupButton;

    @FindBy(xpath = "//div[contains(@class, 'add-cart-form-popup')]")
    private WebElement goToCartPopup;

    @FindBy(xpath = "//div[contains(@class, 'add-cart-form-popup')]/div[2]/a")
    private WebElement goToCartButton;

    @FindBy(xpath = "//div[2]/div[1]/form/input")
    private WebElement inputItemName;

    @FindBy(xpath = "//div[2]/div[1]/form/div[3]/div/div/div[2]/a[1]")
    private WebElement redirectToItemPage;

    @FindAll(@FindBy(xpath = "//div[2]/div[1]/form/div[3]/div/div/div[2]/a[1]/div/p[1]"))
    private List<WebElement> foundItems;

    private final By searchResultsPopupLocator = By.xpath("//div[@class='pre-search']");

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CatalogPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Catalog page is opened.");
        return this;
    }

    public CatalogPage closeCityPopup() {
        closeCityPopupButton.click();
        return this;
    }

    public CatalogPage addToCart(Item item) {By locator = By.xpath("//div[@class='anons-sku'][contains(text(), '" + item.getNumber() + "')]/parent::div//button[@class='element-atb']");
        WebElement addToCartButton = driver.findElement(locator);

        addToCartButton.click();
        return this;
    }

    public CartPage goToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(goToCartPopup));
        goToCartButton.click();
        return new CartPage(driver);
    }

    public CatalogPage searchItems(String query) {
        inputItemName.sendKeys(query);
        return this;
    }

    public List<String> getSearchResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(searchResultsPopupLocator));
        logger.info("Search results popup is shown.");
        return foundItems
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public ItemPage redirectToItemPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(redirectToItemPage));

        redirectToItemPage.click();
        return new ItemPage(driver);
    }

    public CatalogPage waitForLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.urlToBe(PAGE_URL));
        return this;
    }
}
