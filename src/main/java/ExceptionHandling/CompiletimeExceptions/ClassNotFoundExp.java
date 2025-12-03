package ExceptionHandling.CompiletimeExceptions;

public class ClassNotFoundExp {
    public static void main(String[] args) {
        try {
            method1();
        } catch (ClassNotFoundException exceptionObj) {
            // Handle this exception like logging
            System.out.println("Error message: " + exceptionObj.getMessage());
        }

        System.out.println("The program execution is still on!");
    }

    // Throws: delegating the exception handling to its caller
    public static void method1() throws ClassNotFoundException {
        throw new ClassNotFoundException("Testing ClasNotFoundException");
    }

    public static void method2() {
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException exceptionObj) {
            // Handle this exception scenario like logging
            exceptionObj.printStackTrace();
        }
    }
}
