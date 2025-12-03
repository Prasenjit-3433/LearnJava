package CollectionFramework.IterableInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.lang.*;

public class IterableInterface {
    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);

        // Using iterator
        System.out.println("Iterating the values using iterator method:");
        Iterator<Integer> valuesIterator = values.iterator();
        while (valuesIterator.hasNext()) {
            int value = valuesIterator.next();
            System.out.println(value);
            if (value == 3) {
                // removes the last value return by iterator
                valuesIterator.remove();
            }
        }

        System.out.println("Iterating the values using enhanced for-each loop");
        for (int val: values) {
            System.out.println(val);
        }

        // Using forEach method
        System.out.println("Testing forEach method:");
        values.forEach((Integer val) -> System.out.println(val));
    }
}
