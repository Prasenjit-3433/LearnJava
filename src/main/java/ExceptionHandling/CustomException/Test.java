package ExceptionHandling.CustomException;

public class Test {
    public static void main(String[] args) {
        try {
            testCompiletimeException();
        } catch (CustomCompiletimeException exp) {
            System.out.println(exp.getMessage());
        } catch (CustomRuntimeException exp) {
            System.out.println("message: " + exp.getMessage());
        }
    }

    public static void testRuntimeException() {
        // Compiler doesn't force you to handle the exception
        throw new CustomRuntimeException("This's runtime exception");
    }

    public static void testCompiletimeException() throws CustomCompiletimeException {
        // Compiler forces you to handle the exception
        throw new CustomCompiletimeException("This's a compiletime exception");
    }
}
