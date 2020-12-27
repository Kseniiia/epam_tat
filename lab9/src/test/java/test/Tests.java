package test;

import model.Item;
import model.User;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.MainPage;
import page.PersonalAccountPage;
import service.ItemCreator;
import service.UserCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
        String message = "Подписка оформлена";

        String result = new MainPage(driver)
                .openPage()
                .subscribe(user)
                .getSubscriptionPopupTitle();

        assertThat(result, is(equalTo(message)));
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
    public void testFindItem() {
        boolean b = new CatalogPage(driver)
                .openPage().inputItemName().findItem();

        assertThat(b, is(equalTo(true)));
    }
}
