package service;

import model.Buyer;

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
