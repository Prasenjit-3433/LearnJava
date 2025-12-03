package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeqOfStreamOps {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 1, 4, 7, 10);

        // Sequence of stream operations
        Stream<Integer> numStream = nums.stream()
                .filter((Integer val) -> val >= 3)
                .peek((Integer a) -> System.out.println("after filter: " + a))
                .map((Integer val) -> val * -1)
                .peek((Integer val) -> System.out.println("after negating: " + val))
                .sorted()
                .peek((Integer val) -> System.out.println("after sorting: " + val));

        // Note: for some intermediate ops like sorted(), the whole stream has to be present
        //       whereas other intermediate ops can work while the stream being processed

        List<Integer> filteredSortedNumList = numStream.collect(Collectors.toList());
    }
}
