package com.example.lab12.Service;

import com.example.lab12.API.ApiException;
import com.example.lab12.Model.Blog;
import com.example.lab12.Model.User;
import com.example.lab12.Repository.AuthRepository;
import com.example.lab12.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;

    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    public List<Blog> getMyBlogs(Integer userId){
        User user=authRepository.findUserByUserId(userId);
        return blogRepository.findAllByUser(user);
    }


    public void addBlog(Integer userId, Blog blog){
        User user=authRepository.findUserByUserId(userId);
        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void updateBlog(Integer blogId, Integer userId, Blog blog){
        Blog blog1 = blogRepository.findBlogByBlogId(blogId);
        if (blog1 ==null){
            throw new ApiException("wrong blog id");
        }
        if (!blog1.getUser().getUserId().equals(userId)) {
            throw new ApiException("wrong user id");
        }
        blog1.setBody(blog.getBody());
        blogRepository.save(blog1);
    }

    public void deleteBlog(Integer blogId, Integer userId){
        Blog blog = blogRepository.findBlogByBlogId(blogId);
        if (blog ==null){
            throw new ApiException("wrong blog id");
        }
        if (!blog.getUser().getUserId().equals(userId)) {
            throw new ApiException("wrong user id");
        }
        blogRepository.delete(blog);
    }

    public Blog getBlogById(Integer userId, Integer blogId){
        Blog blog = blogRepository.findBlogByBlogId(blogId);
        if (blog ==null){
            throw new ApiException("wrong blog id");
        }
        if (!blog.getUser().getUserId().equals(userId)) {
            throw new ApiException("wrong user id");
        }
       return blog;
    }

    public Blog getBlogByTitle(Integer userId, String title){
        Blog blog = blogRepository.findBlogByTitle(title);
        if (blog ==null){
            throw new ApiException("cannot find blog with this title");
        }
        if (!blog.getUser().getUserId().equals(userId)) {
            throw new ApiException("wrong user id");
        }
        return blog;
    }


}
