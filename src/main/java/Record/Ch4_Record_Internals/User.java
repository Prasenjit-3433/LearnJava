package Record.Ch4_Record_Internals;

public record User(String name, int age) implements Comparable<Integer> {

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
