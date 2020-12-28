package test;

import model.Buyer;
import model.Item;
import org.hamcrest.core.Every;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.ItemPage;
import service.BuyerCreator;
import service.ItemCreator;
import service.SearchQueryCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ItemTests extends CommonConditions {
    @Test
    public void testAddToCart() {
        Item item = ItemCreator.forAddition();

        Item cartItem = new CatalogPage(driver)
                .openPage()
                .closeCityPopup()
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
                .closeCityPopup()
                .searchItems(query)
                .getSearchResults();

        assertThat(results, Every.everyItem(containsStringIgnoringCase(query)));
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
