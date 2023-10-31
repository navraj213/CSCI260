/*
 * Create a program that uses recursion to count by 10’s starting from a specific number that is
    collected by the user. Stop after 20 recursive iterations. Please display the original number
    AND each incremental number after it is computed
 */

import java.util.Scanner;

public class RecursionChallenge {
    public static int x;

    public static void countBy10(int numIterations) {
        if (numIterations <= 0) {
            return;
        }
        
        x+=10;
        System.out.println("The number is: " + x);
        
        countBy10(numIterations-1);       
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        x = input.nextInt();
        
        input.close();

        countBy10(20);
    }
}
