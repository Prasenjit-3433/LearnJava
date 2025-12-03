package CollectionFramework.Set;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeVersion {

    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        Set<Integer> threadSafeSet = concurrentHashMap.keySet();

        threadSafeSet.add(1);
        threadSafeSet.add(2);

        Iterator<Integer> iterator = threadSafeSet.iterator();
    }


}
