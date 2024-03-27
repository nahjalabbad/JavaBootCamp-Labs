package org.example.lab11.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiResponse;
import org.example.lab11.Model.Post;
import org.example.lab11.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getPosts(){
        return ResponseEntity.status(200).body(postService.getAllPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }

        postService.addPost(post);
        return ResponseEntity.ok().body(new ApiResponse("Post Added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        postService.updatePost(id,post);
        return ResponseEntity.ok().body(new ApiResponse("Post updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return ResponseEntity.ok().body(new ApiResponse("Post deleted"));

    }

    //                              EXTRA ENDPOINTS

    @GetMapping("/get-title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title){
        Post post= postService.getPostByTitle(title);
        return ResponseEntity.ok().body(post);

    }

    @GetMapping("/post-before/{date}")
    public ResponseEntity getPostBeforeDate(@PathVariable LocalDate date){
        List<Post> getPosts= postService.getPostBeforeDate(date);
        return ResponseEntity.ok().body(getPosts);

    }

    @GetMapping("/post-category/{categoryName}")
    public ResponseEntity getByCategory(@PathVariable String categoryName){
        List<Post> getPosts= postService.getByCategory(categoryName);
        return ResponseEntity.ok().body(getPosts);
    }

    @GetMapping("/post-user/{id}")
    public ResponseEntity getByUser(@PathVariable Integer id){
        List<Post> getPosts= postService.getByUser(id);
        return ResponseEntity.ok().body(getPosts);
    }
}
