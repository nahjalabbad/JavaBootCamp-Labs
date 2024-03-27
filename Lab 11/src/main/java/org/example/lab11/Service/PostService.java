package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiException;
import org.example.lab11.Model.Category;
import org.example.lab11.Model.Post;
import org.example.lab11.Model.User;
import org.example.lab11.Repository.CategoryRepository;
import org.example.lab11.Repository.PostRepository;
import org.example.lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        User user=userRepository.findUserByUserId(post.getUserId());
        Category category=categoryRepository.findCategoriesByCategoryId(post.getCategoryId());
        if (category==null&&user==null) {
            throw new ApiException("Post ID or User ID does not match the one in the system");
        }
        post.setPublishDate(LocalDate.now());
        postRepository.save(post);
    }

    public void updatePost(Integer id, Post post){

        Post post1=postRepository.findPostByPostId(id);
        if (post1==null){
            throw new ApiException("ID not found");
        }
        post1.setContent(post.getContent());
        post1.setUserId(post.getUserId());
        post1.setTitle(post.getTitle());
        post1.setCategoryId(post.getCategoryId());
        post1.setPublishDate(LocalDate.now());
        postRepository.save(post1);
    }

    public void deletePost(Integer id){
        Post post=postRepository.findPostByPostId(id);

        if (post==null){
            throw new ApiException("ID cannot found");
        }
        postRepository.delete(post);
    }

    public Post getPostByTitle(String title){
        Post post=postRepository.getPostByTitleIgnoreCase(title);
        if (post==null){
            throw new ApiException("Post title not found");
        }
        return post;
    }

    public List<Post> getPostBeforeDate(LocalDate publishDate){
        List<Post> getPosts=postRepository.getPostByPublishDateBefore(publishDate);
        if (getPosts.isEmpty()){
            throw new ApiException("no posts were published by this date");
        }
        return getPosts;
    }

    public List<Post> getByCategory(String categoryName){
        Category category=categoryRepository.findCategoriesByNameIgnoreCase(categoryName);
        List<Post> getPosts=postRepository.findAll();
        List<Post> getPostsByCategory= new ArrayList<>();
        for (Post post:getPosts){
            if (post.getCategoryId().equals(category.getCategoryId())){
              getPostsByCategory=postRepository.getPostByCategoryId(category.getCategoryId());
            }
        }

        if (getPosts.isEmpty()){
            throw new ApiException("Category name not found");
        }
        return getPostsByCategory;
    }

    public List<Post> getByUser(Integer userId){
        List<Post> getPosts=postRepository.getPostByUserId(userId);
        if (getPosts.isEmpty()){
            throw new ApiException("no posts from this user were published");
        }
        return getPosts;
    }


}
