package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.utility.UtilityValidator;

@Service
@RequiredArgsConstructor

class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UtilityValidator utilityValidator;

    @Override
    public UserDTO createUser(User user) {
        utilityValidator.checkUser(user);
        return repository.createUser(user);
    }

    @Override
    public UserDTO getUser(Long id) {
        return repository.getUser(id);
    }

    @Override
    public UserDTO updateUser(Long id, User user) {
        utilityValidator.checkUser(user);
        user.setId(id);
        return repository.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }


}