package by.bsu.operation;

import java.util.ArrayList;

public class NumbersFinder {
    public static boolean determineNumber(int p, int num) {
        int max = (int) Math.pow(10, p) - 1;
        int min = (int) Math.pow(10, p - 1);

        return (num >= min && num <= max);
    }

    public static int findDifferentDigits(int num) {
        int array[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        while (num != 0) {
            int digit = num % 10;
            array[digit]++;
            num = num / 10;
        }

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                count++;
            }
        }

        return count;
    }

    public static ArrayList<Integer> findNumbers(int p, int k, Integer array[]) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++) {
            if (determineNumber(p, array[i])) {
                if (findDifferentDigits(array[i]) <= k) {
                    newArray.add(array[i]);
                }
            }
        }

        return newArray;
    }



}
