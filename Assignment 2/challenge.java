/*
    Using the above code as a reference along with any other references you wish to use as a
    team, create a Java program that adds or removes entries from a linked list based on user
    input.
    You can use the index of the entry as the key to identify the record for addition or deletion.
    The program can be as simple as you like but must add an entry to the list based on the user
    input and also must delete the proper item in the list based on the index entered by the user.
    Display your list contents after each operation.

    Note: Please choose one of the following themes for your program.....
    Students/Classroom
    Sports Scores/Teams
    Passengers/Travel
 */
import java.util.Scanner;
import java.util.LinkedList;

public class challenge {
    public static LinkedList<String> teams = new LinkedList<String>();

    public static void addTeam(String team) {
        teams.add(team);
    }
    public static void removeTeam(String team) {
        teams.remove(team);
    }
    public static void displayTeams() {
        System.out.println("Current Team List is: " + teams);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("Type 'a' to add, 'r' to remove, or 'q' to quit.");
        String keyboard = input.next().toLowerCase();
        while(true) {
            if (keyboard.equals("a")) {
                System.out.println("What's the team you would like to add?");
                String team = input.next();
                addTeam(team);
            } else if (keyboard.equals("r")) {
                System.out.println("What's the team you would like to remove?");
                String team = input.next();
                removeTeam(team);
            } else if (keyboard.equals("q")) {
                break;
            }
            displayTeams();
            System.out.println("Type 'a' to add, 'r' to remove, or 'q' to quit.");
            keyboard = input.next().toLowerCase();
        }

        input.close();
    }
    
}
