package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {
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
        return this;
    }

    public PersonalPage register(String name, String email, String password, String confirmPassword) {
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputConfirmPassword.sendKeys(confirmPassword);
        registrationButton.click();
        return new PersonalPage(driver);
    }

    public RegistrationPage waitForLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals(PAGE_URL);
            }
        };

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(expectation);

        return this;
    }
}
