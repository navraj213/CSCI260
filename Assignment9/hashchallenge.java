package Assignment9;
import java.util.*;
/*
 * a. Use the sample code for the hash table below and confirm functionality on your system. This
      code is also in Canvas under handouts-Hash Sample Code

 * b. Create a program that captures boat names and boat hull numbers (e.g. 2364ZR) at the marina
      from the system user, adds them to a hash table with appropriate keys and then displays the
      values of the hash table when prompted by the user.

 * c. Add a feature in your program from step b for a user to search for a value in the hash table
   using its key and then display the result of the value to the user. Do NOT worry about error
   handling for null values etc. for this exercise.
 */


public class hashchallenge {
    private static Hashtable<String, String> boats = new Hashtable<String, String>();

    public static void addBoat(String name, String hull) {
        boats.put(name, hull);
    }

    public static void printBoats() {
        Enumeration<String> enumeration = boats.elements();
        System.out.print("hashtable values: " );
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 'a' to add a boat, 'p' to print, 's' to search, or 'q' to quit");
            switch (keyboard.nextLine()) {
                case "a":
                    System.out.println("Enter boat name");
                    String name = keyboard.nextLine();
                    System.out.println("Enter boat hull number");
                    String hull = keyboard.nextLine();
                    addBoat(name, hull);
                    break;
                case "p":
                    printBoats();
                    break;
                case "q":
                    System.exit(0);
                    break;
                case "s":
                    System.out.println("Enter boat name to search");
                    String search = keyboard.nextLine();
                    System.out.println(boats.get(search));
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
