package ru.practicum.user;

interface UserRepository {
    UserDTO createUser(User user);

    UserDTO getUser(Long id);

    UserDTO updateUser(User user);

    void deleteUser(Long id);
}