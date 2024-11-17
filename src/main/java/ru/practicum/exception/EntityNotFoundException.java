package ru.practicum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
    //Нужно ли мне добавлять пользовательское исключение в обработчик, при условии, что использую в
    //аннотации статус возвращаемого значения через @ResponseStatus?
}
