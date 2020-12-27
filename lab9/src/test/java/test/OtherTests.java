package test;

import model.Buyer;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.ItemPage;
import page.MainPage;
import page.TelegramPage;
import service.BuyerCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OtherTests extends CommonConditions {
    @Test
    public void testOpenTelegram() {
        String expectedPageTitle = "Telegram: Contact @MileBy";
        String expectedAction = "tg://resolve?domain=MileBy";

        TelegramPage telegramPage = new MainPage(driver)
                .openPage()
                .closeCityPopup()
                .goToTelegramPage()
                .waitForLoad();

        assertThat(telegramPage.getPageTitle(), is(equalTo(expectedPageTitle)));
        assertThat(telegramPage.getAction(), is(equalTo(expectedAction)));
    }

    @Test
    public void testOpenCatalog() {
        CatalogPage catalogPage = new MainPage(driver)
                .openPage()
                .closeCityPopup()
                .showCatalogs()
                .goToCatalog()
                .waitForLoad();

        //assertThat(catalogPage.getPageTitle(), startsWith(""));
    }

    @Test
    public void testBuyQuickly() {
        Buyer buyer = BuyerCreator.forPurchase();
        String expectedMessage = "Ваш заказ отправлен. Спасибо.";

        String result = new ItemPage(driver)
                .openPage()
                .closeCityPopup()
                .showQuickPurchaseForm()
                .buyQuickly(buyer)
                .getBuyQuicklyResult();

        assertThat(result, is(equalTo(expectedMessage)));
    }
}
