package CollectionFramework.PriorityQueue.Comparable;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 7, 2};

        Arrays.sort(arr, Collections.reverseOrder());
        for (int it: arr) {
            System.out.println(it);
        }

        Car[] carArray = new Car[3];
        carArray[0] = new Car("suv", "petrol");
        carArray[1] = new Car("sedan", "diesel");
        carArray[2] = new Car("hatchback", "cng");

        Arrays.sort(carArray, Collections.reverseOrder((Car obj1, Car obj2) -> obj1.name.compareTo(obj2.name)));

        for (Car car: carArray) {
            System.out.println(car.name + " : " + car.type);
        }

    }
}
