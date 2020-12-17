package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
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

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public MainPage openLoginForm() {
        closeCityPopupButton.click();
        loginOrRegisterButton.click();
        return this;
    }

    public PersonalPage login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new PersonalPage(driver);
    }

    public MainPage subscribe(String email) {
        closeCityPopupButton.click();
        subscriptionEmailInput.sendKeys(email);
        subscriptionButton.click();
        return this;
    }

    public RegistrationPage redirectToRegistrationPage() {
        closeCityPopupButton.click();
        loginOrRegisterButton.click();
        registrationButton.click();
        return new RegistrationPage(driver);
    }

    public void waitForSuccessfullSubscriptionPopup() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(subscriptionPopupLocator));
    }
}
