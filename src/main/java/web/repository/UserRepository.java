package web.repository;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(int id);
    void save(User user);
    void deleteById(int id);
    void merge(User user);
}
