package CollectionFramework.DequeAndList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayDequeEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(9);
        list.add(3);
        list.add(7);

        list.forEach((Integer item) -> System.out.print(item + ", "));
        System.out.println();
        // add new element & shifting elements on right
        list.add(1, 2);
        list.forEach((Integer item) -> System.out.print(item + ", "));

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }
    }
}
