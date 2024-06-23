package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    void createOrUpdateUser(User user);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);


}
