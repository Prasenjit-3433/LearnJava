package CollectionFramework.Map;

import java.util.NavigableMap;
import java.util.TreeMap;

public class MyNavigableMap {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(1, "A");
        map.put(21, "B");
        map.put(23, "C");
        map.put(141, "D");
        map.put(25, "E");


    }
}
