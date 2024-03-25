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

    public Integer addApplications(JobApplication application){
        if (jobPostRepository.existsById(application.getJobPostId())&& userRepository.existsById(application.getUserId())) {
            jobApplicationRepository.save(application);
            return 1;
        }
        if (!jobPostRepository.existsById(application.getUserId())){
            return 2;
        }
        return 3;
    }

    public Boolean updateApplications(Integer postId, JobApplication application){
        JobApplication application1=jobApplicationRepository.getById(postId);
        if (application1==null){
            return false;
        }
        application1.setJobPostId(application.getJobPostId());
        application1.setUserId(application.getUserId());
        jobApplicationRepository.save(application);
        return true;
    }

    public Boolean deleteApplications(Integer postId){
        JobApplication application1=jobApplicationRepository.getById(postId);
        if (application1==null){
            return false;
        }
        jobApplicationRepository.delete(application1);
        return true;
    }
}
