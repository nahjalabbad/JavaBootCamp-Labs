package org.example.lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab10.API.ApiResponse;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Service.JobPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getPosts(){
        return ResponseEntity.ok(jobPostService.getPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addPosts(@RequestBody @Valid JobPost post, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        jobPostService.addPosts(post);
        return ResponseEntity.ok().body(new ApiResponse("Post Added"));
    }

    @PutMapping("/update/{jpId}")
    public ResponseEntity updatePosts(@PathVariable Integer jpId, @RequestBody @Valid JobPost post, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        Boolean isUpdated= jobPostService.updatePosts(jpId,post);
        if (isUpdated){
            return ResponseEntity.ok().body(new ApiResponse("Post Updated"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Post ID not found"));

    }

    @DeleteMapping("/delete/{jpId}")
    public ResponseEntity deletePosts(@PathVariable Integer jpId){
        Boolean isDeleted=jobPostService.deletePosts(jpId);
        if (isDeleted){
            return ResponseEntity.ok().body(new ApiResponse("Post Deleted"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Post ID not found"));
    }
}
