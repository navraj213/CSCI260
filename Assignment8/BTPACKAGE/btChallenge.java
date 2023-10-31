package Assignment8.BTPACKAGE;
import java.util.Scanner;

public class btChallenge {
    

    public static void main(String[] args) {
        /*
        * A
        Create an original Java program that uses a Binary Search Tree to capture numeric
            address data (house numbers) from a user, store it to the tree structure and then
            display the full contents of the tree after the data is successfully saved to the tree.
        */
        Scanner input = new Scanner(System.in);
        BT bt = new BT();

        while(true) {
            System.out.println("Enter address to add to the tree (enter any char to exit): ");
            if(input.hasNextInt()) {
                bt.insert(input.nextInt());
            } else {
                break;
            }
        }

        System.out.print("\nThe Tree is the following: ");
        bt.inorder();

        System.out.println("\n\n");

        /*
         * B
         * Add a search function to your program that allows a user to search the binary tree for
            a specific address value in the tree. Include a confirmation notification if the data is
            found in the system.
         */
        input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter address to search for (enter any char to exit): ");
            if(input.hasNextInt()) {
                int address = input.nextInt();
                if(bt.search(address)) {
                    System.out.println("Address found!");
                } else {
                    System.out.println("Address not found!");
                }
            } else {
                break;
            }
        }

        System.out.println("Exiting...");
    }
}
