import java.util.*;

public class challenge1 {
    private static void bubbleSort(ArrayList<Integer> intArray) {
        Integer temp = 0;
        for (int i = 0; i < intArray.size(); i++) {
            for (int j = 1; j < (intArray.size() - i); j++)
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
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter your integer (Type q to quit)");
            String keyboard = input.next();
            try {
                nums.add(Integer.parseInt(keyboard));
            }
            catch(NumberFormatException e)
            {
                break;
            }
        }
        input.close();
        System.out.println();
        System.out.println();
        System.out.println("Current Array: " + nums);
        bubbleSort(nums);
        System.out.println("Sorted Array: " + nums);

    }
}