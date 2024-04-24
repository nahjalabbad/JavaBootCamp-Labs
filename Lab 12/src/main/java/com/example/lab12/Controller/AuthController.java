package com.example.lab12.Controller;

import com.example.lab12.API.ApiResponse;
import com.example.lab12.Model.User;
import com.example.lab12.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/get-all")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(authService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        authService.register(user);
        return ResponseEntity.ok(new ApiResponse("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        authService.login();
        return ResponseEntity.ok(new ApiResponse("Welcome back."));
    }
    @PostMapping("/logout")
    public ResponseEntity logout(){
        authService.logout();
        return ResponseEntity.ok(new ApiResponse("See you soon."));
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@AuthenticationPrincipal User userid,@RequestBody @Valid User user){
        authService.updateUser(userid.getUserId(),user);
        return ResponseEntity.ok(new ApiResponse("user information updated successfully"));
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteUser(@AuthenticationPrincipal User user, @PathVariable String username){
        authService.deleteUser(user.getUserId(), username);
        return ResponseEntity.ok(new ApiResponse("user information deleted successfully"));
    }



}
