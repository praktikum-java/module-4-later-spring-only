package ru.practicum.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ManagerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<Integer,String>> handleValidationError(MethodArgumentNotValidException exception) {
        log.error("Возникла ошибка валидации данных: {}", exception.getMessage());
        Map<Integer, String> response = new HashMap<>();
        /*
        В общем, я нашёл целое непаханное поле в формировании ответа ошибок с различными get при возвращении String и
        если честно, у меня прям глаза разбегаются при формировании нужного ответа в количестве\уровне\детализации
        ответа ошибки. Понимаю что всё это ситуативно и от обстоятельств, но их очень много...
         */
        int count = exception.getErrorCount();
        String errorMessage = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        response.put(count,errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
