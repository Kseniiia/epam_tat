package by.bsu.run;

import by.bsu.creator.ArrayCreator;
import by.bsu.filter.StringFilter;
import by.bsu.operation.NumbersFinder;
import by.bsu.reader.ConsoleReader;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String[] strings;
        System.out.println("Enter the numbers: ");
        ConsoleReader reader = new ConsoleReader();
        StringFilter filter = new StringFilter();
        strings = reader.readStringArray(System.in);
        ArrayCreator creator = new ArrayCreator();
        Integer numbers[] = creator.factoryArray(strings);
        System.out.println("Enter count of different digits: ");
        int k = ConsoleReader.readInt(System.in);
        System.out.println("Enter how many digits in the number: ");
        int p = ConsoleReader.readInt(System.in);
        NumbersFinder finder = new NumbersFinder();
        System.out.println(finder.findNumbers(p, k, numbers));
    }
}
