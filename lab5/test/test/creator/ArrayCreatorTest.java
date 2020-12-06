package test.creator;

import by.bsu.creator.ArrayCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayCreatorTest {
    @Test()
    public static void testFactoryArray() {
        ArrayCreator obj = new ArrayCreator();
        Integer[] array = new Integer[]{2, 4, 67, 3};
        String[] str = new String[]{"2", "4", "67", "3"};
        Integer[] result = obj.factoryArray(str);
        Assert.assertEquals(result, array);
    }

}
