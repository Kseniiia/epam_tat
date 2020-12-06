package by.bsu.reader;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    public static final String REGEX_DELIMITR = "\\s+";

    public String[] readStringArray(InputStream input){
        Scanner scanner = new Scanner(input);
        String line = scanner.nextLine();
        line = line.trim();
        String[] numbers = line.split(REGEX_DELIMITR);
        return numbers;
    }

    public static int readInt(InputStream input) {
        Scanner scanner = new Scanner(input);
        int number = 0;
        boolean continueInput = true;
        do {
            try {
                number = scanner.nextInt();
                continueInput = false;
            } catch(InputMismatchException e) {
                System.out.println("Try Again(Incorrect input: an int is required");
                scanner.nextLine();
            }
        } while (continueInput);
        return number;
    }
}