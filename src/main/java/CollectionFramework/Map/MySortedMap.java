package CollectionFramework.Map;

import java.util.SortedMap;
import java.util.TreeMap;

public class MySortedMap {
    public static void main(String[] args) {
        SortedMap<Integer, String> map1 = new TreeMap<>();
        map1.put(21, "SJ");
        map1.put(11, "PJ");
        map1.put(13, "KJ");
        map1.put(5, "SJ");

        // excluded
        System.out.println(map1.headMap(13));

        // included
        System.out.println(map1.tailMap(13));

        System.out.println(map1.firstKey());
        System.out.println(map1.lastKey());
    }
}
