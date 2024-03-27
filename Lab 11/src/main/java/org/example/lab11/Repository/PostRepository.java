package org.example.lab11.Repository;

import org.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findPostByPostId(Integer postId);

    Post getPostByTitleIgnoreCase(String title);

    List<Post> getPostByPublishDateBefore(LocalDate publishDate);

    List<Post> getPostByCategoryId(Integer categoryId);

    List<Post> getPostByUserId(Integer userId);
}
