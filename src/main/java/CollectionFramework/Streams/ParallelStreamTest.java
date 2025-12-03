package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 100);

        // Sequential processing
        long sequentialProcessingStartTime = System.currentTimeMillis();
        numbers.stream()
                .map((Integer a) -> {
                    try { Thread.sleep(50); } catch(Exception e) {}
                    return a * a;
                })
                .forEach((Integer a) -> System.out.println(a));
        System.out.println("Sequential processing time taken: " + (System.currentTimeMillis() - sequentialProcessingStartTime) + " Milliseconds");

        // Parallel processing
        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream()
                .map((Integer a) -> {
                    try { Thread.sleep(50); } catch(Exception e) {}
                    return a * a;
                })
                .forEach((Integer a) -> System.out.println(a));
        System.out.println("Parallel processing time taken: " + (System.currentTimeMillis() - parallelProcessingStartTime) + " Milliseconds");

    }
}
