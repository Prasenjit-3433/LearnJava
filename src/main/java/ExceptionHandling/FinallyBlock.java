package ExceptionHandling;

import java.io.FileNotFoundException;

public class FinallyBlock {
    public static void main(String[] args) {
        runtimeException();
    }

    public static void method1(String name) throws ClassNotFoundException, InterruptedException {
        if (name.equals("dummy")) {
            throw new ClassNotFoundException();
        } else if (name.equals("interrupted")) {
            throw new InterruptedException();
        }
    }

    private static void method2() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void runtimeException() {
        throw new ArithmeticException();
    }
}
