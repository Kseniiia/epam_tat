package test.operation;

import by.bsu.operation.NumbersFinder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NumbersFinderTest {
    @Test()
    public static void testDetermineNumber() {
        NumbersFinder obj = new NumbersFinder();
        boolean result = obj.determineNumber(1,2);
        Assert.assertEquals(result, true);
    }


    @Test()
    public static void test2DetermineNumber() {
        NumbersFinder obj = new NumbersFinder();
        boolean result = obj.determineNumber(1,2323);
        Assert.assertEquals(result, false);
    }

    @Test()
    public static void testFindDifferentDigits() {
        NumbersFinder obj = new NumbersFinder();
        int result = obj.findDifferentDigits(35644337);
        Assert.assertEquals(result, 5);
    }

    @Test()
    public static void test2FindDifferentDigits() {
        NumbersFinder obj = new NumbersFinder();
        int result = obj.findDifferentDigits(303000);
        Assert.assertEquals(result, 2);
    }

    @Test()
    public static void testFindNumbers() {
        NumbersFinder obj = new NumbersFinder();
        Integer array[] = new Integer[]{1, 45, 76, 44, 4, 11, 2};
        ArrayList<Integer> result = obj.findNumbers(2, 1, array);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(44);
        arrayList.add(11);
        Assert.assertEquals(result, arrayList);
    }

    @Test()
    public static void test2FindNumbers() {
        NumbersFinder obj = new NumbersFinder();
        Integer array[] = new Integer[]{1, 45, 76, 44, 4, 11, 2};
        ArrayList<Integer> result = obj.findNumbers(3, 1, array);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Assert.assertEquals(result, arrayList);
    }

}

