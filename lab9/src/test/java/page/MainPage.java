package page;


import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://mile.by/";

    @FindBy(xpath = "//div[contains(@class, 'city-ip-popup')]/following-sibling::div")
    private WebElement closeCityPopupButton;

    @FindBy(css = "span[onclick='registerbutton();']")
    private WebElement loginOrRegisterButton;

    @FindBy(css = "input[name='LOGIN']")
    private WebElement loginInput;

    @FindBy(css = "input[name='PASSWORD']")
    private WebElement passwordInput;

    @FindBy(css = "button.btn-login")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"subscription-email\"]")
    private WebElement subscriptionEmailInput;

    @FindBy(xpath = "//div[9]/div/form/button")
    private WebElement subscriptionButton;

    @FindBy(css = "[class='link-reg']")
    private WebElement registrationButton;

    private final By subscriptionPopupLocator = By.xpath("//div[contains(@class, 'add-subscription-form-popup')]");

    @FindBy(xpath = "//div[contains(@class, 'add-subscription-form-popup')]/div")
    private WebElement subscriptionPopupTitle;

    @FindBy(css = "[class='telegram']")
    private WebElement telegramButton;

    @FindBy(xpath = "//div[@class='full-catalog-wrap']")
    private WebElement catalogButton;

    private final By catalogPopupLocator = By.xpath("//div[@class='full-catalog-block']");

    @FindBy(xpath = "//div[@class='full-catalog-block']//div[@class='full-catalog-item'][3]")
    private WebElement catalogCategory;

    @FindBy(xpath = "//div[@class='full-catalog-block']//div[@class='full-catalog-item'][3]/div/a[1]")
    private WebElement catalogCategoryLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page is opened.");

        return this;
    }

    public MainPage closeCityPopup() {
        closeCityPopupButton.click();

        return this;
    }

    public MainPage showLoginForm() {
        loginOrRegisterButton.click();
        logger.info("Login form is shown.");

        return this;
    }

    public PersonalPage login(User user) {
        loginInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();

        return new PersonalPage(driver);
    }

    public MainPage subscribe(User user) {
        subscriptionEmailInput.sendKeys(user.getEmail());
        subscriptionButton.click();

        return this;
    }

    public RegistrationPage goToRegistrationPage() {
        loginOrRegisterButton.click();
        registrationButton.click();

        return new RegistrationPage(driver);
    }

    public String getSubscriptionPopupTitle() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(subscriptionPopupLocator));
        logger.info("Subscription popup is shown.");

        return subscriptionPopupTitle.getText();
    }

    public TelegramPage goToTelegramPage() {
        telegramButton.click();

        return new TelegramPage(driver);
    }

    public MainPage showCatalogs() {
        catalogButton.click();

        return this;
    }

    public CatalogPage goToCatalog() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(catalogPopupLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(catalogCategory).perform();
        catalogCategoryLink.click();

        return new CatalogPage(driver);
    }
}
