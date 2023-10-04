/*
 * Programming Challenge 1:
Create a Java program that collects numeric data from a user (10 values minimum), sorts that data using a
bubble sort algorithm in ascending order, and then displays the resulting ordered set
 */
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class challenge1 {
    private static void bubbleSort(ArrayList<Integer> intArray) {
        Integer temp = 0;
        for (int i = 0; i < intArray.size(); i++) {
            for (int j = 1; j < (intArray.size() - i; j++))
            {
                if (intArray.get(j - 1) > intArray.get(j))
                {
                    temp = intArray.get(j - 1);
                    intArray.set(j-1, intArray.get(j));
                    intArray.set(j, temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<integer>();
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter your integer (Type q to quit)");
            String keyboard = input.next();
            try(Integer.parseInteger(keyboard))
            {
                nums.add(Integer.parseInteger(keyboard));
            }
            catch(NumberFormatException e)
            {
                break;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Current Array: " + nums);
        bubbleSort(nums);
        System.out.println("Sorted Array: " + nums);

    }
}
