import java.util.*;
public class midterm {
    public static Scanner input;
    /* 1. 
    * Create a Java program that collects 5 first names from the user, 
    * stores them to an array and then outputs/displays the contents of the array to the user after the 5th name is entered. 
    * (Grading Rubric - Capturing data, use of a loop, use of an array, 5 first names, string value).
    */
    public static void get5Names() {
        input = new Scanner(System.in);
        String[] names = new String[5]; //use of an array

        for (int i = 0; i < 5; i++) { //use of a loop
            System.out.println("Enter a name: "); //5 first names
            names[i] = input.next(); //Capturing data
        }

        System.out.println("\nThe names you entered are: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(names[i]); //string values
        }
    }

    /* 2. Create a Java program that collects 3 annual salaries from the user, stores them to an array list
        and then outputs/displays the contents of the array list to the user after the 3rd annual salary is
        entered. (Grading Rubric - Capturing data, use of a loop, use of an array list, 3 salaries,
        numeric value).
    */
    public static void get3Salaries() {
        input = new Scanner(System.in);
        ArrayList<Integer> salaries = new ArrayList<Integer>(); //use of an array list

        for(int i = 0; i < 3; i++) { //use of a loop
            System.out.println("Enter your " + i + " year's salary: "); //3 salaries
            salaries.add(input.nextInt()); //Capturing data
        }

        System.out.println("\nThe salaries you entered are: ");
        System.out.println(salaries); //numeric value
    }

    /*
     * 3. 
     * Create a Java program that collects 2 countries from the user, stores them to an Linked List and 
     * then outputs/displays the contents of the Linked List to the user after the second country is
     * entered. (Grading Rubric - Capturing data, use of a loop, use of a linked list, 2 countries, string
     * value).
     */
    public static void get2Countries() {
        input = new Scanner(System.in);
        LinkedList<String> countries = new LinkedList<String>(); //use of a linked list

        for(int i = 0; i < 2; i++) { //use of a loop
            System.out.println("Enter a country: "); //2 countries
            countries.add(input.next()); //Capturing data
        }

        System.out.println("\nThe countries you entered are: ");
        System.out.println(countries); //string value
    }

    /*
     * 4.
     * Create a Java program that uses a Stack to store 5 word processing commands of your choice
        (e.g. cut, paste, font size, font style etc.) and then simulate the “undo” function by outputting
        the contents of the stack as... UNDO: [stack element] for all elements (Grading Rubric - Use of
        a loop, use of a stack, 5 word processing features, output simulation).
     */
    public static void get5CommandsUndo() {
        Stack<String> commands = new Stack<String>(); //use of a stack
        input = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            System.out.println("Enter a command: "); //5 word processing features
            commands.push(input.next()); //Capturing data
        }

        for(int i = 0; i < 5; i++) {
            System.out.println("UNDO: " + commands.pop()); //output simulation
        }
    }

    /*
     * 5.
     * Create a Java program that uses a Queue to store 4 word processing commands of your choice
        (e.g. cut, paste, font size, font style etc.) and then simulate the “redo” function by outputting the
        contents of the stack as... REDO: [queue element] for all elements (Grading Rubric - Use of a
        loop, use of a queue, 4 word processing features, output simulation).
     */
    public static void get4CommandsRedo() {
        Queue<String> commands = new LinkedList<String>(); //use of a queue
        input = new Scanner(System.in);

        for(int i = 0; i < 4; i++) {
            System.out.println("Enter a command: "); //4 word processing features
            commands.add(input.next()); //Capturing data
        }

        for(int i = 0; i < 4; i++) {
            System.out.println("REDO: " + commands.remove()); //output simulation
        }
    }

    /*
     * 6.
     * Create a Java program that uses an Array to capture 5 numeric integers from the user, sort those
        integers using a bubble sort algorithm, and then output/display the sorted data. (Grading Rubric
        - Capturing data, use of a loop, use of an array, use of a bubble sort algorithm, output of data)
     */
    public static void get5Nums() {
        input = new Scanner(System.in);
        int[] nums = new int[5]; //use of an array

        for(int i = 0; i < 5; i++) { //use of a loop
            System.out.println("Enter a number: "); //Capturing data
            nums[i] = input.nextInt();
        }

        //Bubble sort algorithm
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        System.out.print("\nThe sorted numbers are: ");
        for(int i = 0; i < 5; i++) {
            System.out.print(nums[i] + ", "); //output of data
        }
    }


    //TESTING PURPOSES
    public static void main(String[] args) {
        System.out.println("\n\n1. ");
        get5Names();

        System.out.println("\n\n2. ");
        get3Salaries();

        System.out.println("\n\n3. ");
        get2Countries();

        System.out.println("\n\n4. ");
        get5CommandsUndo();

        System.out.println("\n\n5. ");
        get4CommandsRedo();

        System.out.println("\n\n6. ");
        get5Nums();
        input.close();
    }
}