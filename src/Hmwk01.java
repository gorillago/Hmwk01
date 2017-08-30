//Riley Flint

//Reads all the integers found in the file "input.txt"
//and prints out the number of integers found, the
//smallest integer found, the largest integer found,
//and the average of all the integers (rounded to two
//decimal points.)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hmwk01 {
    public static void main(String[] args) {
        File input = new File("input.txt");

        int[] ints = getInts(input);

        printResults(ints);
    }

    /**
     * Returns an array of integers found in the file supplied.
     *
     * @param file File you would like to read integers from.
     * @return Returns an array of integers found in the inputted file.
     */
    private static int[] getInts(File file) {
        Scanner scanner = null;
        //Uses the countIntegers method to find out how large the array needs to be.
        int[] result = new int[countIntegers(file)];

        //Surround with try/catch to handle FileNotFoundException
        //if the file is missing or inaccessible for any reason.
        try {
            scanner = new Scanner(file);
        }
        //If FileNotFoundException is thrown, "File "(Name of File)" does not exist."
        //is printed out for the user in the err stream and the program is terminated.
        catch (FileNotFoundException e) {
            System.err.println("File \"" + file.getName() + "\" does not exist.");
            System.exit(1);
        }

        //If the scanner finds an int, read ints until it can't find another.
        if (scanner.hasNextInt()) {
            int count = 0;
            //For as long as there is a next int in the file, add it to the result array.
            while (scanner.hasNextInt()) {
                result[count++] = scanner.nextInt();
            }
        }
        //If the scanner does not find an int, it will print out
        //"File "(Name of File)" does not contain any integers." in
        //the err  and the program is terminated.
        else {
            System.err.println("File \""+file.getName()+"\" does not contain any integers.");
            System.exit(1);
        }
        scanner.close();
        //Returns an array of integers found in the file.
        return result;
    }

    /**
     * Counts the number of integers in a file.
     *
     * @param file File to count the integers in.
     * @return Returns the number of integers found in the file.
     */
    private static int countIntegers(File file) {
        int result = 0;

        Scanner scanner = null;
        //Surround with try/catch to handle FileNotFoundException
        //if the file is missing or inaccessible for any reason.
        try {
            scanner = new Scanner(file);
        }
        //If FileNotFoundException is thrown, "File "(Name of File)" does not exist."
        //is printed out for the user in the err stream and the program is terminated.
        catch (FileNotFoundException e) {
            System.err.println("File \"" + file.getName() + "\" does not exist.");
            System.exit(1);
        }


        //If the scanner finds an int, read ints until it can't find another.
        if (scanner.hasNextInt()) {
            int count = 0;
            //The count variable is incremented for each integer that is found in the file.
            while (scanner.hasNextInt()) {
                scanner.nextInt();
                count++;
            }
            result = count;
        }
        //If the scanner does not find an int, it will print out
        //"File "(Name of File)" does not contain any integers." in
        //the err  and the program is terminated.
        else {
            System.err.println("File \""+file.getName()+"\" does not contain any integers.");
            System.exit(1);
        }
        if (result == 0) {
            System.err.println("File \""+file.getName()+"\" does not contain any integers.");
            System.exit(1);
        }
        scanner.close();
        //Returns the number of integers found in the file.
        return result;
    }

    /**
     * Prints the total amount of integers, smallest and largest
     * integer, and the average of the inputted integers.
     *
     * @param ints Ints to print the results of.
     */
    private static void printResults(int[] ints) {
        System.out.println("Integers read: " + ints.length);
        System.out.println("Smallest Integer: " + getSmallest(ints));
        System.out.println("Largest Integer: " + getLargest(ints));
        System.out.println("Average: " + getAverage(ints));
    }

    /**
     * Returns the smallest int in the array supplied.
     *
     * @param ints Array of ints to find the smallest one.
     * @return Returns the smallest int found in the supplied array.
     */
    private static int getSmallest(int[] ints) {
        //Sets the variable smallestInt to the first value in the array.
        int smallestInt = ints[0];
        //Iterates through the array of ints supplied.
        for (int i : ints) {
            //If the int in the current iteration is smaller than the value of the smallestInt
            //variable, then the smallestInt value is replaced by the variable i in the current iteration.
            if (i < smallestInt) {
                smallestInt = i;
            }
        }
        //Returns the smallest int found in the supplied array.
        return smallestInt;
    }

    /**
     * Returns the largest int in the array supplied.
     *
     * @param ints Array of ints to find the largest one.
     * @return Returns the largest int found in the supplied array.
     */
    private static int getLargest(int[] ints) {
        //Sets the variable largestInt to the first value in the array.
        int largestInt = ints[0];
        //Iterates through the array of ints supplied.
        for (int i : ints) {
            //If the variable i in the current iteration is larger than the value of the largestInt
            //variable, then the largestInt value is replaced by the variable i in the current iteration.
            if (i > largestInt) {
                largestInt = i;
            }
        }
        //Returns the largest int found in the supplied array.
        return largestInt;
    }

    /**
     * Returns the sum of the supplied ints.
     *
     * @param ints Array of ints to find the sum of.
     * @return Returns the sum of the supplied ints.
     */
    private static int getSum(int[] ints) {
        //The sum starts at 0.
        int sum = 0;
        //Iterates through the array of ints supplied.
        for (int i : ints) {
            //Adds each value in the array of ints to the sum.
            sum += i;
        }
        //Returns the sum of the supplied ints.
        return sum;
    }

    /**
     * Returns the average of the array of integers.
     *
     * @param ints Array of ints to find the average of.
     * @return Returns the average of the array of integers.
     */
    private static double getAverage(int[] ints) {
        //Uses the getSum method I created to get the sum of the integers.
        double sum = getSum(ints);
        //Sets the numbers variable to the amount of numbers in the ints array.
        double numbers = ints.length;
        //Figures the average of the supplied array of ints.
        double average = sum/numbers;
        //Rounds the average down to two decimal points.
        double round = Math.round(average * 100.0) / 100.0;
        //Returns the average of the array of integers.
        return round;
    }
}
