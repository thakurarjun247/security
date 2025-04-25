package security.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
    GlobalExceptionHandler() {
        System.out.println("GlobalExceptionHandler constructed" + GlobalExceptionHandler.class);
    }



    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException exception) {
        return new ResponseEntity<>("oops, error: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception exception) {
        System.out.println("handleGeneralException invoked");
        if (exception instanceof EventNotFoundException) {
            return new ResponseEntity<>("generic exception", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        // Log and handle unexpected errors
        return new ResponseEntity<>("Found a different exception: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //even this couldb't catch anything
    //disabled white lable in props file
    //HTTP Status 500 – Internal Server Error is the error i get now

}
