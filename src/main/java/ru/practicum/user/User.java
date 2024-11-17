package ru.practicum.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    private Long id;
    @Email @NotNull
    private String email;
    private String name;
}
