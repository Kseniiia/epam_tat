package test.filter;

import by.bsu.filter.StringFilter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringFilterTest {
    @Test()
    public static void testFilterInt() {
        StringFilter obj = new StringFilter();
        String[] str = new String[]{"3", "12", "2", "f"};
        String[] result = obj.filterInt(str);
        String[] resultStr = new String[]{"3", "12", "2"};
        Assert.assertEquals(result, resultStr);
    }

    @Test()
    public static void test2FilterInt() {
        StringFilter obj = new StringFilter();
        String[] str = new String[]{"3", ".", "dkdk", "f"};
        String[] result = obj.filterInt(str);
        String[] resultStr = new String[]{"3"};
        Assert.assertEquals(result, resultStr);
    }
}
