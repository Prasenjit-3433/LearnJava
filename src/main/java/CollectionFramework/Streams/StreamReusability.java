package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReusability {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);

        Stream<Integer> filteredNumbers = numbers.stream()
                .filter((Integer a) -> a >= 3);

        // once a terminal ops is called, it closed the stream
        filteredNumbers.forEach((Integer a) -> System.out.println(a));

        // trying to use the closed stream
        List<Integer> listFromStream = filteredNumbers.collect(Collectors.toList());
    }
}
