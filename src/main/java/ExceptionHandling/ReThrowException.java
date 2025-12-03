package ExceptionHandling;

public class ReThrowException {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            method1();
        } catch (ClassNotFoundException exp) {
            // do some logging and then re-throw the exception
            throw exp;
        }
    }

    public static void method1() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
