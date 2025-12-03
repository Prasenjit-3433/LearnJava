package ExceptionHandling.RuntimeExceptions;

public class ArithmeticExp {
    public static void main(String[] args) {
        divideByZero();
    }

    private static void method1() {
        throw new ArithmeticException();
    }

    public static void divideByZero() {
        int val = 5 / 0;
    }
}
