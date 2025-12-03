package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);

        // forEach(Consumer): perform action on each element, DOES NOT return any value
        numbers.stream()
                .filter((Integer val) -> val >= 3)
                .forEach((Integer val) -> System.out.print(val + " "));
        // Output: 4, 7, 10


        // toArray(): Collects the elements of the stream into an array
        Object[] filteredNumArr1 = numbers.stream()
                .filter((Integer a) -> a >= 3)
                .toArray();

        Integer[] filteredNumArr2 = numbers.stream()
                .filter((Integer a) -> a >= 3)
                .toArray((int size) -> new Integer[size]);

        System.out.println();

        // reduce(BinaryOperator): does reduction on the elements of the stream. perform associative aggregation function
        Optional<Integer> reducedValue = numbers.stream()
                .reduce((Integer a, Integer b) -> a + b);

        System.out.println("Reduced value: " + reducedValue.get());
        // Output: 24

        // collect(Collector): can be used to collect the elements of the steam into a list
        List<Integer> filteredNumbers = numbers.stream()
                .filter((Integer a) -> a >= 3)
                .collect(Collectors.toList());


        // min(Comparator) / max(Comparator): Finds the min or max from the stream based on the comparator provided
        Optional<Integer> minValueType1 = numbers.stream()
                .filter((Integer val) -> val >= 3)
                .min((Integer a, Integer b) -> a-b);
        // sorting after filter: 4, 7, 10
        // min = left most, max = right

        System.out.println("sorting after filter: " + minValueType1.get());

        Optional<Integer> minValueType2 = numbers.stream()
                .filter((Integer val) -> val >= 3)
                .min((Integer a, Integer b) -> b-a);
        // sorting after filter: 10, 7, 4
        // min = left most, max = right

        System.out.println("sorting after filter: " + minValueType2.get());

        // count(): returns the count of element present in the stream
        long noOfValuePresent = numbers.stream()
                .filter((Integer val) -> val >= 3)
                .count();

        System.out.println("Count: " + noOfValuePresent); // count: 3

        // anyMatch(Predicate): checks if any value in the stream match the given predicate and returns boolean
        boolean hasValueGreaterThanThree = numbers.stream()
                .anyMatch((Integer a) -> a >= 3);
        System.out.println("has ANY Value Greater Than 3: " + hasValueGreaterThanThree);
        // output: true

        // allMatch(Predicate): checks if all value in the stream match the given predicate and returns boolean
        boolean hasAllValueGreaterThanThree = numbers.stream()
                .allMatch((Integer a) -> a >= 3);
        
        System.out.println("has ALL Value Greater Than 3: " + hasAllValueGreaterThanThree);
        // output: false

        // noneMatch(Predicate): checks if NO value in the stream match the given predicate and returns boolean

        // findFirst(): finds the first element of the stream
        Optional<Integer> firstValue = numbers.stream()
                .filter((Integer a) -> a >= 3)
                .findFirst();

        System.out.println("findFirst: " + firstValue.get());
        // Output: 4
    }
}
