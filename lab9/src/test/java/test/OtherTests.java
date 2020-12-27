package test;

import model.Item;
import model.User;
import org.hamcrest.core.Every;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.MainPage;
import page.PersonalAccountPage;
import page.TelegramPage;
import service.ItemCreator;
import service.SearchQueryCreator;
import service.UserCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OtherTests extends CommonConditions {
    @Test
    public void testOpenTelegram() {
        String expectedPageTitle = "Telegram: Contact @MileBy";
        String expectedAction = "tg://resolve?domain=MileBy";

        TelegramPage telegramPage = new MainPage(driver)
                .openPage()
                .goToTelegramPage()
                .waitForLoad();

        assertThat(telegramPage.getPageTitle(), is(equalTo(expectedPageTitle)));
        assertThat(telegramPage.getAction(), is(equalTo(expectedAction)));
    }
}
