package linkedlist1;
import java.util.LinkedList;
public class RemoveFirstLast {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();

        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");

        System.out.println("LinkedList contains : " + lList);

        Object object = lList.removeFirst();
        System.out.println(object + " has been removed from the first index of LinkedList");
        System.out.println("LinkedList now contains : " + lList);

        object = lList.removeLast();
        System.out.println(object + " has been removed from the last index of LinkedList");
        
        System.out.println("LinkedList now contains : " + lList);
    }
}