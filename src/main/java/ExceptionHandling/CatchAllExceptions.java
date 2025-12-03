package ExceptionHandling;

public class CatchAllExceptions {
    public static void main(String[] args) {
        try {
            method1("interrupted");
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.print("Generic Exception Handling: ");
            System.out.println(exception.getMessage());
        }
    }

    public static void method1(String name) throws ClassNotFoundException, InterruptedException {
        if (name.equals("dummy")) {
            throw new ClassNotFoundException("Class Not Found!");
        } else if(name.equals("interrupted")) {
            throw new InterruptedException("Program execution interrupted!");
        }
    }
}
