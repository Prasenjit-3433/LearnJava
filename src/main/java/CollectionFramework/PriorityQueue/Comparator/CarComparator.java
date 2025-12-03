package CollectionFramework.PriorityQueue.Comparator;

import java.util.Comparator;

public class CarComparator implements Comparator<Car>  {
    @Override
    public int compare(Car obj1, Car obj2) {
        return obj2.name.compareTo(obj1.name);
    }
}


