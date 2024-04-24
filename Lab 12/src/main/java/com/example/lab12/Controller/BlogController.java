package com.example.lab12.Controller;

import com.example.lab12.API.ApiResponse;
import com.example.lab12.Model.Blog;
import com.example.lab12.Model.User;
import com.example.lab12.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get-all")
    public ResponseEntity getAllBlogs(){
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/get")
    public ResponseEntity getMyBlogs(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(blogService.getMyBlogs(user.getUserId()));
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal User user, @RequestBody @Valid Blog blog){
        blogService.addBlog(user.getUserId(), blog);
        return ResponseEntity.ok(new ApiResponse("blog added"));
    }

    @PutMapping("/update/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId, @RequestBody @Valid Blog blog){
        blogService.updateBlog(user.getUserId(), blogId, blog);
        return ResponseEntity.ok(new ApiResponse("blog updated"));
    }

    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId){
        blogService.deleteBlog(user.getUserId(), blogId);
        return ResponseEntity.ok(new ApiResponse("blog deleted"));

    }

    @GetMapping("/getid/{blogId}")
    public ResponseEntity getBlogById(@AuthenticationPrincipal User user,@PathVariable Integer blogId ){
        return ResponseEntity.ok(blogService.getBlogById(user.getUserId(), blogId));
    }


    @GetMapping("/get-title/{title}")
    public ResponseEntity getMyBlogs(@AuthenticationPrincipal User user, @PathVariable String title){
        return ResponseEntity.ok(blogService.getBlogByTitle(user.getUserId(),title));
    }
}
