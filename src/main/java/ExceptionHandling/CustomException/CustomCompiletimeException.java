package ExceptionHandling.CustomException;

// In java, we don't have built-in `CompiletimeException` like `RuntimeException`
// Any class that extends `Exception` class will be treated as `CompiletimeException`
// Any class that extends `RuntimeException` class will be treated as RuntimeException
public class CustomCompiletimeException extends Exception {

    public CustomCompiletimeException(String message) {
        super(message);
    }
}