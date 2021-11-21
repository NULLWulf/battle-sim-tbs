package com.army_builder.systems;

import java.util.Scanner;
import com.army_builder.models.*;

public class Validator {

    // input is incoming int, maxval
    public int checkInt(int minVal, int maxVal, String parameter){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        do {
            System.out.printf("Enter %s: ",parameter);
            System.out.printf("Enter a number between %d and %d: ", minVal, maxVal);
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            input = sc.nextInt();
        } while (input <= 0);
        return input;

    }

    public String checkIfString(String parameter){
        Scanner sc = new Scanner(System.in);
        String input = null;
        do {
            System.out.printf("Enter %s: ", parameter);
            while (containsDigit(input)) {
                System.out.println("String must not include digits");
                sc.next(); // this is important!
            }
            input = sc.nextLine();
        } while (containsDigit(input));
        return input;

    }

    public final boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit == Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }
}
