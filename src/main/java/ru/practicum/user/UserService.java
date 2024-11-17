package ru.practicum.user;


interface UserService {
    UserDTO createUser(User user);

    UserDTO getUser(Long id);

    UserDTO updateUser(Long id, User user);

    void deleteUser(Long id);
}