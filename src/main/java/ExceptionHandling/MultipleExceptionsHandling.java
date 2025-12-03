package ExceptionHandling;

import java.io.FileNotFoundException;

public class MultipleExceptionsHandling {
    public static void main(String[] args) {
        // catch block - can only catch those exceptions which are thrown by try block
        try {
            method1("dummy");
            method2();
        } catch (ClassNotFoundException exceptionObj) {
            // handle it
        } catch (InterruptedException exceptionObj) {
            // handle it accordingly
        } catch (FileNotFoundException exception) {
            // do it
        }

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
}
