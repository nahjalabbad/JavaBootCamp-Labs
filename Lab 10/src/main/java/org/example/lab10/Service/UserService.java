package org.example.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab10.Model.User;
import org.example.lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUsers(User user) {
        userRepository.save(user);
    }

    public Boolean updateUsers(Integer id, User user) {
        User user1 = userRepository.getById(id);
        if (user1 == null) {
            return false;
        }
        user1.setAge(user.getAge());
        user1.setRole(user.getRole());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        userRepository.save(user1);
        return true;
    }

    public Boolean deleteUsers(Integer id) {
        User user1 = userRepository.getById(id);
        if (user1 == null) {
            return false;
        }
        userRepository.delete(user1);
        return true;
    }
}
