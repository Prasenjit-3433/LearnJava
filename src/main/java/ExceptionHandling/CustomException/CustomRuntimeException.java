package ExceptionHandling.CustomException;

// In java, we DON'T have built-in `CompiletimeException` like `RuntimeException`
// Any class that extends `Exception` class will be treated as `CompiletimeException`
// Any class that extends `RuntimeException` class will be treated as RuntimeException
public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException(String message) {
        super(message);
    }
}