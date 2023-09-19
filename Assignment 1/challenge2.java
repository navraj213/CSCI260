import java.util.ArrayList;
import java.util.Scanner;

public class challenge2 {

    public static ArrayList<String> createArrayList() {
        ArrayList<String> myArray = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a string to add to the array list (type quit to quit): ");
            String userInput = input.nextLine();
            if (userInput.equals("quit")) {
                break;
            } else {
                myArray.add(userInput);
            }
        }
        input.close();
        return myArray;
    }

    public static void printArrayList(ArrayList<String> myArray) {
        System.out.println("The array list contains: ");
        for (String x : myArray) {
            System.out.print(x + ", ");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> myArray = createArrayList();
        System.out.println("FINSIHED CREATING ARRAY LIST");
        printArrayList(myArray);
        System.out.println();
    }
}


