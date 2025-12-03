package CollectionFramework.Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    private static void withoutStream() {
        List<Integer> salaryList = new ArrayList<>();

        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);

        // count of salary > 3000
        int count = 0;
        for (int salary : salaryList) {
            if (salary > 3000) count++;
        }

        System.out.println("Count of salary > 3000: " + count);
    }

    private static void withStream() {
        List<Integer> salaryList = new ArrayList<>();

        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);

        // step 1: open a stream - stream() is a default method in Collection interface.
        // step 2: appy 1 or more intermediate operations
        // Step 3: apply exactly 1 terminal operation, to trigger the processing of the stream
        long output = salaryList.stream().filter((Integer salary) -> salary > 3000).count();
        System.out.println("Count of salary > 3000: " + output);
    }

    public static void main(String[] args) {
//        withoutStream();
        withStream();
    }

}
