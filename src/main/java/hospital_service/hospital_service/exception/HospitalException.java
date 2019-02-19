package hospital_service.hospital_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HospitalException extends RuntimeException {

    private List<String> errors;

    public HospitalException(String message) {
        super(message);
    }

    public HospitalException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
