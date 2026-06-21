package test.contacts.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import test.contacts.dto.ErrorDTO;
import test.contacts.dto.ResponseDTO;

import java.util.List;

@ControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResponseDTO<Void>> handleResponseStatusException(ResponseStatusException e) {
        var response = new ResponseDTO<Void>();

        response.setErrors(
                List.of(
                        new ErrorDTO(
                                "Ошибка",
                                e.getReason()
                        )
                )
        );

        return ResponseEntity.status(e.getStatusCode()).body(response);
    }
}
