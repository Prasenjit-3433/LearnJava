package ExceptionHandling.RuntimeExceptions;

public class IllegalArgumentExp {
    public static void main(String[] args) {
        // Right:
        int a = Integer.parseInt("53");

        // Wrong: NumberFormatException
        int b = Integer.parseInt("abc");
    }
}
