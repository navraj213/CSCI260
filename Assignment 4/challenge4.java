import java.util.*;
public class challenge4 {
    public static void main(String[] args) {
        /*
         * You have just started work at your first programming job and you have been offered a salary
            plus benefits as part of your employment package. One of your benefits is the option to
            contribute to a 401k or a 403b plan to save for retirement. Write a program using a Stack(s)
            data structure that......

            a. Captures the amount you wish to contribute each year
            b. The percentage of interest that you think you will earn each year on average
            c. A display of the earnings you will earn each year over a 30 year period from the most
            recent year back to the first year
         */

         //a
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount you wish to contribute each year: ");
        double contribution = input.nextDouble();

        //b
        System.out.println("Enter the percentage of interest that you think you will earn each year on average: ");
        double interest = input.nextDouble();

        //c
        Stack<Double> earnings = new Stack<Double>();
        double total = 0;
        for(int i = 0; i < 30; i++) {
            total += contribution;
            earnings.push(total);
            total += total * interest;
        }

        System.out.println("Earnings: ");
        for(int i = 0; i < 30; i++) {
            System.out.println(earnings.pop());
        }

        System.out.println("Total Balance: " + total);

        input.close();
    }
}