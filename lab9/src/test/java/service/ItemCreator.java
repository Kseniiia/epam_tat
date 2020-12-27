package service;

import model.Item;

public class ItemCreator {
    public static final String ITEM_TO_ADD_NUMBER = "testdata.itemToAdd.number";
    public static final String ITEM_TO_ADD_NAME = "testdata.itemToAdd.name";
    public static final String ITEM_TO_ADD_PRICE = "testdata.itemToAdd.price";

    public static Item forAddition() {
        Item item = new Item(TestDataReader.getTestData(ITEM_TO_ADD_NUMBER));

        item.setName(TestDataReader.getTestData(ITEM_TO_ADD_NAME));
        item.setPrice(Double.parseDouble(TestDataReader.getTestData(ITEM_TO_ADD_PRICE)));

        return item;
    }
}
