package ExceptionHandling;

import java.io.FileNotFoundException;

public class MultipleExpInOneCatch {
    public static void main(String[] args) {
        try {
            method1("interrupted");
            method2();
        } catch (ClassNotFoundException | InterruptedException exp) {
            // handle the exception
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    public static void method1(String name) throws ClassNotFoundException, InterruptedException {
        if (name.equals("dummy")) {
            throw new ClassNotFoundException();
        } else if (name.equals("interrupted")) {
            throw new InterruptedException();
        }
    }

    public static void method2() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
