package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiException;
import org.example.lab11.Model.Comment;
import org.example.lab11.Model.Post;
import org.example.lab11.Model.User;
import org.example.lab11.Repository.CommentRepository;
import org.example.lab11.Repository.PostRepository;
import org.example.lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public void addComment(Comment comment){
        User user=userRepository.findUserByUserId(comment.getUserId());
        Post post=postRepository.findPostByPostId(comment.getPostId());
        if (post==null&&user==null) {
            throw new ApiException("Post ID or User ID does not match the one in the system");
        }
        comment.setCommentDate(LocalDate.now());
        commentRepository.save(comment);
    }

    public void updateComment(Integer id, Comment comment){

        Comment comment1=commentRepository.findCommentByCommentId(id);
        if (comment1==null){
            throw new ApiException("ID not found");
        }

        comment1.setContent(comment.getContent());
        comment1.setUserId(comment.getUserId());
        comment1.setPostId(comment.getPostId());

        commentRepository.save(comment1);
    }

    public void deleteComment(Integer id){
        Comment comment=commentRepository.findCommentByCommentId(id);

        if (comment==null){
            throw new ApiException("ID cannot found");
        }
        commentRepository.delete(comment);
    }

    //                              EXTRA ENDPOINTS

    public List<Comment> getCommentByUser(Integer userId){
        List<Comment> getAllComments=commentRepository.getCommentByUserId(userId);
        if (getAllComments.isEmpty()){
            throw new ApiException("User ID not found");
        }
        return getAllComments;
    }

    public List<Comment> getCommentByPost(Integer postId){
        List<Comment> getAllComments=commentRepository.getCommentByPostId(postId);
        if (getAllComments.isEmpty()){
            throw new ApiException("No comments for this post were found");
        }
        return getAllComments;
    }

    public List<Comment> getCommentBetweenDates(LocalDate before, LocalDate after){
        List<Comment> getAllComments=commentRepository.findCommentsByCommentDateBetween(before,after);
        if (getAllComments.isEmpty()){
            throw new ApiException("No comments between those dates were found");
        }
        return getAllComments;
    }

}
