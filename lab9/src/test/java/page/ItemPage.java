package page;

import model.Buyer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://mile.by/catalog/vytyazhki-dlya-kukhni/vytyazhka-kukhonnaya-sata-p-3260-bk-b-product/";

    @FindBy(xpath = "//div[contains(@class, 'city-ip-popup')]/following-sibling::div")
    private WebElement closeCityPopupButton;

    @FindBy(xpath = "//span[contains(@class, 'title')]")
    private WebElement buyQuicklyButton;

    @FindBy(css = ".quick-order input[name='NAME']")
    private WebElement inputName;

    @FindBy(css = ".quick-order input[name='PHONE']")
    private WebElement inputPhone;

    @FindBy(xpath = "//div[3]/div/div[19]/div[2]/form/button")
    private WebElement buyButton;

    private final By buyQuicklyPopupLocator = By.xpath("//div[contains(@class, 'popup-item quick-order')]");
    private final By buyQuicklyResultLocator = By.cssSelector(".quick-order .quick-form-popup-success");

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Item page is opened.");

        return this;
    }

    public ItemPage closeCityPopup() {
        closeCityPopupButton.click();

        return this;
    }

    public ItemPage showQuickPurchaseForm() {
        buyQuicklyButton.click();

        return this;
    }

    public ItemPage buyQuickly(Buyer buyer) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(buyQuicklyPopupLocator));
        inputName.sendKeys(buyer.getName());
        inputPhone.sendKeys(buyer.getPhone());
        buyButton.click();

        return this;
    }

    public String getBuyQuicklyResult() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(buyQuicklyResultLocator));

        return driver.findElement(buyQuicklyResultLocator).getText();
    }

}
