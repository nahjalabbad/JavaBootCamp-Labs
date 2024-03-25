package org.example.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Model.User;
import org.example.lab10.Repository.JobPostRepository;
import org.example.lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public List<JobPost> getPosts(){
        return jobPostRepository.findAll();
    }

    public Integer addPosts(JobPost post){
        List<User> users=userRepository.findAll();
        for (User user:users){
        if (user.getRole().equalsIgnoreCase("EMPLOYER")) {
            post.setPostingDate(LocalDate.now());
            jobPostRepository.save(post);
            return 1;
            }
        }
        return 2;
    }

    public Boolean updatePosts(Integer postId,JobPost post) {
        List<User> users = userRepository.findAll();
        JobPost post1 = jobPostRepository.getById(postId);
        for (User user : users) {
            if (post1 == null && user.getRole().equalsIgnoreCase("JOB_SEEKER")) {
                return false;
            }}
            post1.setTitle(post.getTitle());
            post1.setDescription(post.getDescription());
            post1.setLocation(post.getLocation());
            post1.setSalary(post.getSalary());
            post1.setPostingDate(post.getPostingDate());
            jobPostRepository.save(post1);
            return true;
        }

    public Boolean deletePosts(Integer postId){
        List<User> users=userRepository.findAll();
        JobPost post1 = jobPostRepository.getById(postId);
        for (User user:users) {
            if (post1 == null && user.getRole().equalsIgnoreCase("JOB_SEEKER")) {
                return false;
            }
        }
        jobPostRepository.delete(post1);
        return true;
    }
}
