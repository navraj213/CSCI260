public class RecursionDemo2 {
    public static int x = 0;

    static void p(int y) {
        System.out.println("The next number is: " + x);
        x=x+y;
        p(y);
    }
    public static void main(String[] args) {
        p(5);
    }
}
