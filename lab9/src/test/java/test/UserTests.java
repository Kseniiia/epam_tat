package test;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import page.PersonalAccountPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTests extends CommonConditions {
    @Test
    public void testLogin() {
        User user = UserCreator.forLogin();

        PersonalAccountPage accountPage = new MainPage(driver)
                .openPage()
                .closeCityPopup()
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
                .closeCityPopup()
                .subscribe(user)
                .getSubscriptionPopupTitle();

        assertThat(result, is(equalTo(expectedMessage)));
    }

    @Test
    public void testRegister() {
        User user = UserCreator.forRegistration();

        PersonalAccountPage accountPage = new MainPage(driver)
                .openPage()
                .closeCityPopup()
                .goToRegistrationPage()
                .waitForLoad()
                .register(user)
                .waitForLoad()
                .goToAccountPage()
                .openPage();

        assertThat(accountPage.getFullName(), is(equalTo(user.getFullName())));
        assertThat(accountPage.getEmail(), is(equalTo(user.getEmail())));
    }
}
