package ru.practicum.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody @Valid User user) {
        log.info("Создан пользователь ={}", user.getName());
        return userService.createUser(user);
    }

    @PatchMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody User user) {
        log.info("Пользовател c id ={} обвновлён в базе данных", id);
        return userService.updateUser(id, user);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
        log.info("Пользовател c id ={} удалён из базы данных", id);
    }

}