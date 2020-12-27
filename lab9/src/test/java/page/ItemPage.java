package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends AbstractPage {
    private final String PAGE_URL = "https://mile.by/catalog/vytyazhki-dlya-kukhni/vytyazhka-kukhonnaya-schtoff-divina-600-black-product/";

    /*@FindBy(xpath = "//div[1]/div[3]/div[2]/div/div[1]/div[1]/div[2]")
    private WebElement itemType;*/

    @FindBy(xpath = "//div[@class='characteristic-item ch_paint_type']//div[@class='characteristic-value']/span")
    private WebElement itemType;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getItemType() {
        return itemType.getText();
    }

    public ItemPage waitForLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals(PAGE_URL);
            }
        };

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(expectation);
        return this;
    }
}
