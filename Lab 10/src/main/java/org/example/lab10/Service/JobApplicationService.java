package org.example.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab10.Model.JobApplication;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Model.User;
import org.example.lab10.Repository.JobApplicationRepository;
import org.example.lab10.Repository.JobPostRepository;
import org.example.lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    public List<JobApplication> getApplications(){
        return jobApplicationRepository.findAll();
    }

    public Integer addApplications(JobApplication application) {
        List<User> users = userRepository.findAll();
        List<JobPost> posts = jobPostRepository.findAll();
        for (User user : users) {
            for (JobPost post : posts) {
                if (post.getId().equals(application.getJobPostId())) {
                    if (user.getId().equals(application.getUserId())) {
                        if (user.getRole().equalsIgnoreCase("JOB_SEEKER")) {
                            jobApplicationRepository.save(application);
                            return 1;
                        }
                    }
                    return 2;
                }
            }
        }
        return 3;
    }

    public Boolean updateApplications(Integer postId, JobApplication application){
        List<User> users=userRepository.findAll();
        JobApplication application1=jobApplicationRepository.getById(postId);
        for (User user:users){
        if (application1==null&& user.getRole().equalsIgnoreCase("JOB_SEEKER")){
            return false;
            }
        }
        application1.setJobPostId(application.getJobPostId());
        application1.setUserId(application.getUserId());
        jobApplicationRepository.save(application);
        return true;
    }

    public Boolean deleteApplications(Integer postId){
        JobApplication application1=jobApplicationRepository.getById(postId);
        List<User> users=userRepository.findAll();
        for (User user:users){
        if (application1==null&& user.getRole().equalsIgnoreCase("JOB_SEEKER")){
            return false;
            }
        }
        jobApplicationRepository.delete(application1);
        return true;
    }
}
