package CollectionFramework.CollectionInterface;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionInterface {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(1);
        values.add(4);
        values.add(2);

        // Note: Collection vs Collections
        // Attention: `Collections` is a utility class, and hence all its methods are static like Collections.sort()
        //            Whereas `Collection` is an interface
        System.out.println("Max: " + Collections.max(values));
        System.out.println("Min: " + Collections.min(values));


        Collections.sort(values);
        System.out.println("Sorting done!...");
        values.forEach((Number val) -> System.out.println(val));
    }

}
