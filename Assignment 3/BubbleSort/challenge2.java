package BubbleSort;
import java.util.Random;

public class challenge2 {
    private static int[] createArray() {
        int[] array = new int[25];
                    for (int i = 0; i < array.length; i++)
        {
            Random rand = new Random();
            array[i] = rand.nextInt(10000);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = createArray();

        System.out.println("Current Array: ");
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        
        System.out.println("\nSorted Array: ");
        BubbleSort.bubbleSort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
