public class challenge1 {
    // Programming Challenge 1:
    // Create a JAVA program that reads in 10 unique values from an array and then displays each number next to its natural
    // logarithm. The display format is flexible and up to you how you want to display the values on screen.
    // Java Hint: “Math”
    // Note: Each student must submit their solution to Canvas for the assignment to count

    public static void findLog(int x) {
        System.out.println("Number: " + x + " | Natural Log: " + Math.log(x));
    }

    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        for (int x : numbers) {
            findLog(x);
        }
    }
}
