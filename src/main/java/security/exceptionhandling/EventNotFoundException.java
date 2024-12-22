package security.exceptionhandling;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String s) {
        super(s);
    }
}
