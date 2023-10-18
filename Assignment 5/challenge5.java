import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class challenge5 {
    /*
     * Programming Challenge 5b:
Using the above code as a reference along with any other references you wish to use as a
team, create a Java program that collects a home value, a down payment amount for your home, a
principle amount, and an annual interest rate (fixed). Using a queue data structure, calculate (and
display) the amount you will be paying each month for the first 12 months of your mortgage. Your
monthly mortgage amounts (interest only) should be added to the queue as part of your program and
then displayed once finished.
Pseudocode (just a recommendation):
1. Collect home value
2. Collect downpayment
3. Collect interest rate
4. Collect monthly principle (non-interest amount you want to pay bank each month)
5. Subtract downpayment from home value
6. Calculate interest payment for first month
7. Add principle to interest
8. Subtract (principle + interest) from adjusted home value (value-downpayment)
9. Add interest value to queue
10. Set new home value = (adjusted home value - current interest payment)
11. Loop through 12 times to calculate interest payments for first 12 months
Note: If done correctly the interest values should be descending for each cycle since you are
paying down the loan.
SIMPLY COLLECTING THE DATA, CALCULATING THE VALUES PROPERLY, AND
STORING THEM TO A QUEUE IS SATISFACTORY FOR THIS ASSIGNMENT. OUTPUT
FORMAT OR ORDER IS NOT REQUIRED FOR THIS ASSIGNMENT

     */

     public static void main(String[] args)
     {
         Queue<Double> queue = new LinkedList<Double>();
         Scanner input = new Scanner(System.in);
         System.out.println("Enter Home Value");
         int homeValue = input.nextInt();
         System.out.println("Enter Down Payment");
         int downPayment = input.nextInt();
         System.out.println("Enter Interest Rate");
         double interestRate = input.nextDouble();
         System.out.println("Enter Monthly Principle");
         int monthlyPrinciple = input.nextInt();

         int newHomeValue = homeValue - downPayment;
         double interestPayment = interestRate * monthlyPrinciple;




         for(int i=0; i<12; i++)
         {
             double monthlyI=(interestRate/12/100)*newHomeValue;
             monthlyI+=monthlyPrinciple;
             queue.add(monthlyI);
             newHomeValue-=monthlyI+monthlyPrinciple;
         }
         System.out.println(queue);


     }
}
