package edu.jhu;

import java.util.regex.Pattern;

public class Main {

    /**
     * Program main entry point
     *
     * @param args user input
     */
    public static void main(String[] args) {
        // calculate product
        calculateProduct(args);
    }

    /**
     * method used to validate and calculate the product of two numbers
     *
     * @param args input form console
     */
    private static void calculateProduct(String[] args) {
        // validate arguments
        if (areArgsValid(args)) {
            // perform operation
            int product = product(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            // if result is negative format result
            if (product > 0) {
                // display result
                System.out.println(String.format("The product of %s and %s is = %d", args[0], args[1], product));
            } else {
                // display result
                System.out.println(String.format("The product of %s and %s is = (%d)", args[0], args[1], product * -1));
            }
        } else {
            // terminate program
            System.out.println("Invalid input, please try again.");
        }
    }

    /**
     * Method used to multiply two integers
     *
     * @param a first number
     * @param b second number
     * @return product of a and b (a*b)
     */
    private static int product(int a, int b) {
        // return the product of a and b
        return a * b;
    }

    /**
     * Method used to check if a string is a integer
     *
     * @param input unvalidated user input
     * @return true if input is integer, false if it is not.
     */
    private static boolean isValidInteger(String input) {
        // regular expression used to validate input
        final String INTEGER_REGEX = "-?[0-9]{0,10}";
        // returns true or false based on the validity of the input
        return Pattern.matches(INTEGER_REGEX, input);
    }

    /**
     * Method used to validate arguments passed to the program using the command prompt
     *
     * @param args user input
     * @return true if there are more than 2 arguments and the arguments are integers
     */
    static private boolean areArgsValid(String[] args) {
        // check if there are at least 2 arguments
        if (args.length < 2) {
            System.out.println("You need to pass at least 2 numbers");
            return false;
        }
        // validate if arguments are valid integers
        for (int i = 0; i < args.length; i++) {
            String input = args[i];
            // print arguments
            System.out.println(String.format("Argument %d: %s", i, input));
            // if any of the arguments is not an integer return false
            if (!isValidInteger(input)) {
                System.out.println("The input is invalid. Please enter only integers");
                System.out.println(String.format("Invalid input: %s", input));
                return false;
            }
        }
        // return true if arguments are valid
        return true;
    }
}