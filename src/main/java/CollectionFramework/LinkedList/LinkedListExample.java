package CollectionFramework.LinkedList;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Using deque functionality
        list.addLast(200);
        list.addLast(300);
        list.addLast(400);
        list.addFirst(100);
        System.out.println(list.getFirst());

        // Using list functionality
    }
}
