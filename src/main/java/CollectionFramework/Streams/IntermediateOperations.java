package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class IntermediateOperations {
    public static void main(String[] args) {
        // filter(Predicate): used to filter the elements
        Stream<String> nameStream = Stream.of("Hello", "How", "Are", "You", "Doing");
        Stream<String> filteredStream = nameStream.filter((String name) -> name.length() <= 3);

        List<String> filteredNamesList = filteredStream.collect(Collectors.toList());

        // map(Function): used to transform each element
        Stream<String> upperCaseStream = Stream.of("HELLO", "HOW", "ARE", "YOU", "DOING");
        Stream<String> transformedStream = upperCaseStream.map((String name) -> name.toLowerCase());

        List<String> lowerCaseNames = transformedStream.collect(Collectors.toList());

        // Flatmap(Function): used to flatten any nested collection
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I", "LOVE", "JAVA"),
                Arrays.asList("CONCEPTS", "ARE", "CLEAR"),
                Arrays.asList("ITS", "VERY", "EASY")
        );

        Stream<String> wordStream1 = sentenceList.stream().flatMap((List<String> sentence) -> sentence.stream());
        // Output: I, LOVE, JAVA, CONCEPTS, ARE, CLEAR, ITS, VERY, EASY

        Stream<String> wordStream2 = sentenceList.stream()
                .flatMap((List<String> sentence) -> sentence.stream().map((String word) -> word.toLowerCase()));
        // output: i, love, java, concepts, are, clear, its, very, easy

        // distinct(): removes duplicates from the stream
        Integer[] arr1 = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        Stream<Integer> arrStream = Arrays.stream(arr1).distinct();

        int[] arr2 = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        IntStream intStream = Arrays.stream(arr2).distinct();

        // sorted(): sorts the elements
        Integer[] unsortedArr = {1, 5, 2, 7, 4, 4, 2, 0, 9};
        Stream<Integer> ascStream = Arrays.stream(unsortedArr).sorted();
        Stream<Integer> descStream = Arrays.stream(unsortedArr).sorted((Integer a, Integer b) -> b - a);

        // peek(Consumer): Helps you to see the intermediate result of the stream which is getting processed
        List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> numStream = numbers.stream()
                .filter((Integer val) -> val > 2) // 3, 4, 6
                .peek((Integer val) -> System.out.println(val)) // print 3, 4, 6
                .map((Integer val) -> val * -1);
        List<Integer> numList = numStream.collect(Collectors.toList());

        // limit(): Truncate the stream, to have no longer than given maxSize
        List<Integer> longList = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> limitedStream = longList.stream().limit(3);

        List<Integer> limitedList = limitedStream.collect(Collectors.toList());
        // Output: 2, 1, 3

        // skip(): skips the first n elements of the stream
        List<Integer> entireList = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> skippedStream = entireList.stream().skip(3);

        List<Integer> skippedList = skippedStream.collect(Collectors.toList());
        // Output: 4, 6

        // mapToInt(ToIntFunction): helps to work with primitive "int" data type
        List<String> strNumbs = Arrays.asList("2", "1", "4", "7");
        IntStream intStream2 = strNumbs.stream().mapToInt((String val) -> Integer.parseInt(val));
        int[] primitiveInt = intStream2.toArray();
        // Output (int): [2, 1, 4, 7]

        int[] testArr = {2, 1, 4, 7};
        IntStream intStream3 = Arrays.stream(testArr);
        IntStream filteredIntStream = intStream3.filter((int val) -> val > 2);
        int[] filteredIntStreamArr = filteredIntStream.toArray();

        // mapToLong(ToLongFunction): helps to work with primitive "long" data type
        List<String> longNumbStr = Arrays.asList("782", "595", "859", "522", "856");
        LongStream longStream = longNumbStr.stream().mapToLong((String val) -> Long.parseLong(val));
        long[] primitiveLongs = longStream.toArray();
        // Output (long): [782, 595, 859, 522, 856]

        // mapToDouble(ToDoubleFunction): helps to work with primitive "double" data type
        List<String> doubleNumStr = Arrays.asList("3.2f", "2.3f", "2.5f", "9.3f");
        DoubleStream doubleStream = doubleNumStr.stream().mapToDouble((String val) -> Double.parseDouble(val));
        double[] primitiveDoubles = doubleStream.toArray();

        // Output (double): [3.2, 2.3, 2.5, 9.3]
    }
}
