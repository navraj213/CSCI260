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

import java.util.LinkedList;
public class challenge {
    private LinkedList<String> teams = new LinkedList<String>();
    
    public void addTeam(String team) {
        teams.add(team);
    }
    public void removeTeam(String team) {
        teams.remove(team);
    }
    public void displayTeams() {
        System.out.println("Current Team List is: " + teams);
    }
    public static void main(String[] args) {
        
    }
    
}
