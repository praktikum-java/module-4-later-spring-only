package ru.practicum.utility;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.practicum.exception.EntityNotFoundException;
import ru.practicum.item.Item;
import ru.practicum.item.ItemRepositoryImpl;
import ru.practicum.user.User;
import ru.practicum.user.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Component
@AllArgsConstructor
public class UtilityValidator {

    private final UserRepositoryImpl userRepository;
    private final ItemRepositoryImpl itemRepository;

    public void checkUser(User user) {
        for (User checkUser : userRepository.getUsers().values()) {
            if (checkUser.getEmail().equals(user.getEmail())) {
                throw new ValidationException("Ошибка валидации, пользователь с данным email уже существует");
            }
        }
    }

    public void checkUserId(Long id) {
        if (!userRepository.getUsers().containsKey(id)) {
            throw new EntityNotFoundException(String.format("Пользователь с id=%s не обнаружен", id));
        }
    }

    public Long getItemFromUser(Long id) {
        for (Item item : itemRepository.getItems().values()) {
            if (item.getOwner().equals(id)) {
                return item.getId();
            }
        }
        throw new EntityNotFoundException("Предмет пользователя не был обнаружен");
    }

    public List<Long> getKeys(Long id) {
        List<Long> keys = new ArrayList<>();
        for (Item item: itemRepository.getItems().values()) {
            if (Objects.equals(item.getOwner(), id)) {
                keys.add(item.getId());
            }
        }
        return keys;
    }


}
