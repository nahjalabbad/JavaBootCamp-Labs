package org.example.lab11.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiResponse;
import org.example.lab11.Model.User;
import org.example.lab11.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }

        userService.addUser(user);
        return ResponseEntity.ok().body(new ApiResponse("User Added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        userService.updateUser(id,user);
        return ResponseEntity.ok().body(new ApiResponse("User updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse("User deleted"));

    }


    //                              EXTRA ENDPOINTS

    
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity logIn(@PathVariable String username,@PathVariable String password ){
        userService.logIn(username,password);
        return ResponseEntity.ok().body(new ApiResponse("Login successful"));
    }
}
