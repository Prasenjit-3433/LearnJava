package CollectionFramework.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyTest {
    public static void main(String[] args) {
        // why we call "intermediate operations" are lazy?
        List<Integer> nums = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numStream = nums.stream()
                                    .filter((Integer val) -> val >= 3)
                                    .peek((Integer val) -> System.out.println(val));
        // peek() is still a "intermediate operation"
        // unless a "terminal operation" is invoked, stream processing doesn't get stated!
        numStream.count();
    }
}
