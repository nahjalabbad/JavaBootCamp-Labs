package org.example.lab11.Repository;

import org.example.lab11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findCommentByCommentId(Integer commentId);

    List<Comment> getCommentByUserId(Integer userId);

    List<Comment> getCommentByPostId(Integer postId);

    List<Comment> findCommentsByCommentDateBetween(LocalDate before, LocalDate after);
}
