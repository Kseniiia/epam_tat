package service;

public class SearchQueryCreator {
    public static final String TESTDATA_SEARCH_QUERY = "testdata.searchQuery";

    public static String fromProperty() {
        return TestDataReader.getTestData(TESTDATA_SEARCH_QUERY);
    }
}
