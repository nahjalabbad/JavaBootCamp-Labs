package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiException;
import org.example.lab11.Model.User;
import org.example.lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){

        User user1=userRepository.findUserByUserId(id);
        if (user1==null){
            throw new ApiException("ID not found");
        }

        user1.setEmail(user1.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());

        userRepository.save(user1);
    }

    public void deleteUser(Integer id){
        User user=userRepository.findUserByUserId(id);

        if (user==null){
            throw new ApiException("ID cannot found");
        }
        userRepository.delete(user);

    }


    //                              EXTRA ENDPOINTS
    public User logIn(String username, String password) {
        User user = userRepository.logIn(username, password);
        if (user == null) {
            throw new ApiException("username or password are wrong ");
        }
        return user;
    }

}
