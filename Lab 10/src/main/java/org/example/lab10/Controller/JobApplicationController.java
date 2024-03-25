package org.example.lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab10.API.ApiResponse;
import org.example.lab10.Model.JobApplication;
import org.example.lab10.Service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/application")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(jobApplicationService.getApplications());
    }

    @PostMapping("/add")
    public ResponseEntity addApplications(@RequestBody @Valid JobApplication application, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        Integer application1= jobApplicationService.addApplications(application);
        if (application1==1) {
            return ResponseEntity.ok().body(new ApiResponse("Application Applied"));
        }
        if (application1==2){
            return ResponseEntity.badRequest().body(new ApiResponse("User ID not found"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Post ID not found"));
    }

    @PutMapping("/update/{jaId}")
    public ResponseEntity updateApplications(@PathVariable Integer jaId, @RequestBody @Valid JobApplication application, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        Boolean isUpdated= jobApplicationService.updateApplications(jaId,application);
        if (isUpdated){
            return ResponseEntity.ok().body(new ApiResponse("Application Updated"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Application ID not found"));

    }

    @DeleteMapping("/delete/{jaId}")
    public ResponseEntity deleteApplications(@PathVariable Integer jaId){
        Boolean isDeleted=jobApplicationService.deleteApplications(jaId);
        if (isDeleted){
            return ResponseEntity.ok().body(new ApiResponse("Application Deleted"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Application ID not found"));
    }
}
