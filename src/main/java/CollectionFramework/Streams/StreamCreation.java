package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {

        // From collection
        List<Integer> salaryList1 = Arrays.asList(3000, 4100, 9000, 1000, 3500);
        Stream<Integer> stream = salaryList1.stream();

        // From array (non-primitive)
        Integer[] salaryList2 = {3000, 4100, 9000, 1000, 3500};
        Stream<Integer> streamFromNonPrimitive =  Arrays.stream(salaryList2);

        // From array (primitive)
        int[] salaryList3 = {3000, 4100, 9000, 1000, 3500};
        IntStream streamFromPrimitive = Arrays.stream(salaryList3);

        // From static method
        Stream<Integer> streamFromStaticMethod = Stream.of(3000, 4100, 9000, 1000, 3500);

        // From stream builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(3000).add(4100).add(9000).add(1000).add(3500);

        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();

        // From stream iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1000, (Integer n) -> n + 5000).limit(5);
    }
}
