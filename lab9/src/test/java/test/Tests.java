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

public class Tests extends CommonConditions {
    @Test
    public void testLogin() {
        User user = UserCreator.forLogin();

        PersonalAccountPage accountPage = new MainPage(driver)
                .openPage()
                .showLoginForm()
                .login(user)
                .waitForLoad()
                .goToAccountPage()
                .openPage();

        assertThat(accountPage.getFullName(), is(equalTo(user.getFullName())));
        assertThat(accountPage.getEmail(), is(equalTo(user.getEmail())));
    }

    @Test
    public void testSubscribe() {
        User user = UserCreator.forSubscription();
        String expectedMessage = "Подписка оформлена";

        String result = new MainPage(driver)
                .openPage()
                .subscribe(user)
                .getSubscriptionPopupTitle();

        assertThat(result, is(equalTo(expectedMessage)));
    }

    @Test
    public void testRegister() {
        User user = UserCreator.forRegistration();

        PersonalAccountPage accountPage = new MainPage(driver)
                .openPage()
                .goToRegistrationPage()
                .waitForLoad()
                .register(user)
                .waitForLoad()
                .goToAccountPage()
                .openPage();

        assertThat(accountPage.getFullName(), is(equalTo(user.getFullName())));
        assertThat(accountPage.getEmail(), is(equalTo(user.getEmail())));
    }

    @Test
    public void testAddToCart() {
        Item item = ItemCreator.forAddition();

        Item cartItem = new CatalogPage(driver)
                .openPage()
                .addToCart(item)
                .goToCart()
                .waitForLoad()
                .getFirstItem();

        assertThat(cartItem, is(equalTo(item)));
    }

    @Test
    public void testSearchItems() {
        String query = SearchQueryCreator.fromProperty();

        List<String> results = new CatalogPage(driver)
                .openPage()
                .searchItems(query)
                .getSearchResults();

        assertThat(results, Every.everyItem(containsStringIgnoringCase(query)));
    }

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
