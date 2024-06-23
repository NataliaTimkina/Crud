package web.service;

import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public void createOrUpdateUser(User user) {
        if (user.getId() == 0) userRepository.save(user);
        else {
            userRepository.merge(user);
        }

    }

    @Override
    @Transactional
    public void createUser(User user) {
        userRepository.save(user);

    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.merge(user);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }
}
