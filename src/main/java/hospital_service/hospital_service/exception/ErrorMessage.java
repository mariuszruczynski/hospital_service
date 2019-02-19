package hospital_service.hospital_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorMessage {

    private List<String> errors;
}
