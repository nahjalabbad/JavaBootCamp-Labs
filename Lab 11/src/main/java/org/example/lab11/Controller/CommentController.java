package org.example.lab11.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiResponse;
import org.example.lab11.Model.Comment;
import org.example.lab11.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getComments(){
        return ResponseEntity.status(200).body(commentService.getAllComments());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }

        commentService.addComment(comment);
        return ResponseEntity.ok().body(new ApiResponse("Comment Added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        commentService.updateComment(id,comment);
        return ResponseEntity.ok().body(new ApiResponse("Comment updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().body(new ApiResponse("Comment deleted"));

    }

    //                              EXTRA ENDPOINTS

    @GetMapping("/comment-user/{id}")
    public ResponseEntity getCommentByUser(@PathVariable Integer id){
       List<Comment> getComments= commentService.getCommentByUser(id);
        return ResponseEntity.ok().body(getComments);

    }

    @GetMapping("/comment-post/{id}")
    public ResponseEntity getCommentByPost(@PathVariable Integer id){
        List<Comment> getComments= commentService.getCommentByPost(id);
        return ResponseEntity.ok().body(getComments);

    }

    @GetMapping("/comment-between/{before}/{after}")
    public ResponseEntity getCommentBetweenDates(@PathVariable LocalDate before, @PathVariable LocalDate after){
        List<Comment> getComments= commentService.getCommentBetweenDates(before,after);
        return ResponseEntity.ok().body(getComments);

    }
}
