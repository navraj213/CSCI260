public class challenge1 {
    public static void findLog(int x) {
        System.out.println("Number: " + x + " | Natural Log: " + Math.log(x));
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        for (int x : numbers) {
            findLog(x);
        }
    }
}
