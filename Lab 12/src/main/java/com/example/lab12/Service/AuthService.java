package com.example.lab12.Service;

import com.example.lab12.API.ApiException;
import com.example.lab12.Model.User;
import com.example.lab12.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;


    public void login(){

    }

    public void logout(){

    }


    public List<User> getAllUsers(){

        return authRepository.findAll();
    }


    public void register(User user){
        user.setRole("CUSTOMER");
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);

        authRepository.save(user);
    }


    public void updateUser(Integer userId,User user){
        User user1=authRepository.findUserByUserId(userId);
        user1.setUsername(user.getUsername());
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user1.setPassword(hashPassword);
        authRepository.save(user1);

    }


    public void deleteUser(Integer userId, String username1){
        User user1=authRepository.findUserByUsername(username1);
        authRepository.delete(user1);
    }






}
