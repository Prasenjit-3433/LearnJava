package CollectionFramework.PriorityQueue.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Car[] carArray = new Car[3];
        carArray[0] = new Car("suv", "petrol");
        carArray[1] = new Car("sedan", "diesel");
        carArray[2] = new Car("hatchback", "cng");

        // Option 1: Declaring Comparator using Lambda on fly
        Arrays.sort(carArray, (Car obj1, Car obj2) -> obj2.name.compareTo(obj1.name));

        // Option 2: Declaring Comparator using Lambda
        Comparator<Car> carComparatorLambda = (Car car1, Car car2) -> car2.name.compareTo(car1.name);
        Arrays.sort(carArray, carComparatorLambda);

        // Option 3: Declaring Comparator using concrete class
        Arrays.sort(carArray, new CarComparator());

        for (Car car: carArray) {
            System.out.println(car.name + ".." + car.type);
        }

    }
}
