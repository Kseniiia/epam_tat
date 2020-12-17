package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalAccountPage extends AbstractPage {
    private final String PAGE_URL = "https://mile.by/personal/private";
    
	@FindBy(css = "input[name='FIO']")
	private WebElement fullName;

	@FindBy(css = "input[name='EMAIL']")
	private WebElement email;
    
    public PersonalAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    
    public PersonalAccountPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
    
    public String getFullName() {
    	return fullName.getAttribute("value");
    }
    
    public String getEmail() {
    	return email.getAttribute("value");
    }
}
