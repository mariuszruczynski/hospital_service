package hospital_service.hospital_service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HospitalExceptionErrorsHandler {

    @ExceptionHandler(value = {HospitalException.class})
    public ResponseEntity<Object> handleProjectAssignmentException(HospitalException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getErrors());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
