/*
 * Programming Challenge 1:
Create a Java program that collects numeric data from a user (10 values minimum), sorts that data using a
bubble sort algorithm in ascending order, and then displays the resulting ordered set
 */
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class challenge1 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<integers>();
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter your integer (Type q to quit)");
            String keyboard = input.next();
            try(Integer.parseIntegr(keyboard))
            {
                nums.add(Integer.parseInteger(keyboard));
            }
            catch(NumberFormatException)
            {
                break;
            }
        }
    }
}
