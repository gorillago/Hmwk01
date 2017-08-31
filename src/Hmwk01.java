//Riley Flint

//Reads all the integers found in the file "input.txt"
//and prints out the number of integers found, the
//smallest integer found, the largest integer found,
//the sum of all of the integers, and the average of
//all the integers (rounded to two decimal points.)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hmwk01 {
    public static void main (String[] args) {
        File inputFile = new File("input.txt");

        try {
            Scanner input = new Scanner(inputFile);

            if (input.hasNext()) {
                int count = 0;
                int smallest = Integer.MAX_VALUE;
                int largest = Integer.MIN_VALUE;
                int sum = 0;

                while (input.hasNext()) {
                    String currentString = input.next();

                    if (isInteger(currentString)) {
                        int current = getInteger(currentString);

                        if (current < smallest) {
                            smallest = current;
                        }
                        if (current > largest) {
                            largest = current;
                        }

                        sum += current;

                        count++;
                    }
                    else {
                        System.out.println("\""+currentString+"\" is not an integer.");
                    }
                }
                input.close();

                double average = (double)sum/(double)count;
                double averageRounded = Math.round(average * 100.0) / 100.0;

                System.out.println(count + " integers read.");
                System.out.println("Smallest: " + smallest);
                System.out.println("Largest: " + largest);
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + averageRounded);
            }
            else {
                System.out.println("\""+inputFile.getName()+"\" is empty.");
                System.exit(1);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("\""+inputFile.getName()+"\" does not exist.");
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int getInteger(String input) {
        return Integer.parseInt(input);
    }
}
