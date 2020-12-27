package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://mile.by/register/";

    @FindBy(css = "input[name='FIO']")
    private WebElement inputName;

    @FindBy(css = "input[name='EMAIL']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[1]/div/div/div/form[1]/div[3]/input")
    private WebElement inputPassword;

    @FindBy(css = "input[name='CONFIRM_PASSWORD']")
    private WebElement inputConfirmPassword;

    @FindBy(css = "button.btn-registration")
    private WebElement registrationButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public RegistrationPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Registration page is opened.");
        return this;
    }

    public PersonalPage register(User user) {
        inputName.sendKeys(user.getFullName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        inputConfirmPassword.sendKeys(user.getConfirmPassword());
        registrationButton.click();
        return new PersonalPage(driver);
    }

    public RegistrationPage waitForLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.urlToBe(PAGE_URL));
        logger.info("Registration page is loaded.");
        return this;
    }
}
