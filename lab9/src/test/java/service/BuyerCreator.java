package service;

import model.Buyer;
import model.User;

public class BuyerCreator {
    public static final String BUY_QUICKLY_NAME = "testdata.buyQuickly.name";
    public static final String BUY_QUICKLY_PHONE = "testdata.buyQuickly.phone";

    public static Buyer forPurchase() {
        Buyer buyer = new Buyer();

        buyer.setName(TestDataReader.getTestData(BUY_QUICKLY_NAME));
        buyer.setPhone(TestDataReader.getTestData(BUY_QUICKLY_PHONE));

        return buyer;
    }
}
