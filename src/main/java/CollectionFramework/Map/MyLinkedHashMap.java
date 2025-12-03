package CollectionFramework.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkedHashMap {
    public static void main(String[] args) {

        System.out.println("-----------------bellow is LinkedHashMap output-------------------");

        Map<Integer, String> map1 = new LinkedHashMap<>();

        map1.put(1, "A");
        map1.put(21, "B");
        map1.put(23, "C");
        map1.put(141, "D");
        map1.put(25, "E");

        map1.forEach((Integer key, String val) -> System.out.println(key + " : " + val));

        System.out.println("-----------------bellow is Hash Map output-------------------");

        Map<Integer, String> map2 = new HashMap<>();

        map2.put(1, "A");
        map2.put(21, "B");
        map2.put(23, "C");
        map2.put(141, "D");
        map2.put(25, "E");

        for(Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-----------------bellow is LinkedHashMap output-------------------");
        System.out.println("-----------------Access Order Preserved-------------------");

        Map<Integer, String> map3 = new LinkedHashMap<>(16, 0.75F, true);

        map3.put(1, "A");
        map3.put(21, "B");
        map3.put(23, "C");
        map3.put(141, "D");
        map3.put(25, "E");

        // accessing some data
        map3.get(23);
        map3.forEach((Integer key, String val) -> System.out.println(key + " : " + val));

        System.out.println("--------------Synchronized version of LinkedHashMap------------");
        Map<Integer, String> threadSafeMap = Collections.synchronizedMap(new LinkedHashMap<>());

        threadSafeMap.put(1, "A");
        threadSafeMap.put(21, "B");
        threadSafeMap.put(23, "C");
        threadSafeMap.put(141, "D");
        threadSafeMap.put(25, "E");

        threadSafeMap.get(141);
    }
}
