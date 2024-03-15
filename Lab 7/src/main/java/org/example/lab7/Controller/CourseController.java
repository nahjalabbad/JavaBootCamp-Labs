package org.example.lab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab7.API.ApiResponse;
import org.example.lab7.Model.Course;
import org.example.lab7.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return ResponseEntity.ok(courseService.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourses(@RequestBody @Valid Course course, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService.addCourses(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course has been added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourses(@PathVariable int id, @RequestBody @Valid Course course, Errors errors){
        boolean isUpdated=courseService.updateCourses(id,course);
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (isUpdated){
            return ResponseEntity.ok().body(new ApiResponse("Course has been updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourses(@PathVariable int id){
        boolean isDeleted=courseService.deleteCourse(id);
        if (isDeleted){
            return ResponseEntity.ok().body(new ApiResponse("Course has been deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @GetMapping("/search/{type}")
    public ResponseEntity searchByType(@PathVariable String type){
        ArrayList<Course>byType=courseService.searchByType(type);
        if (byType==null){
            return ResponseEntity.status(400).body(new ApiResponse("no course under this type were found"));
        }
        return ResponseEntity.ok().body(byType);
    }
    @GetMapping("/getcourse/{id}")
    public ResponseEntity getCourse(@PathVariable int id){
        Course course=courseService.getCourse(id);
        if (course==null){
            return ResponseEntity.status(400).body(new ApiResponse("ID not Found"));
        }
        return ResponseEntity.ok().body(course);
    }

    @PutMapping("/availability/{id}/{available}")
    public ResponseEntity availability(@PathVariable int id, @PathVariable boolean available){
        boolean isAvailable= courseService.availability(id,available);
        if (isAvailable){
            return ResponseEntity.ok().body(new ApiResponse("Course availability has been updated"));
        }
    return ResponseEntity.status(400).body(new ApiResponse("ID not Found"));

    }
    @GetMapping("/availableCourses/{available}")
    public ResponseEntity availableCourses(@PathVariable boolean available){
        ArrayList<Course> availableCourses=courseService.availableCourses(available);

        if (availableCourses==null){
            return ResponseEntity.status(400).body(new ApiResponse("no available courses were found"));
        }
        return ResponseEntity.ok().body(availableCourses);
    }
    @PutMapping("/enrollment/{id}/{seats}")
    public ResponseEntity enrollment(@PathVariable int id,@PathVariable int seats){
        Course courseEnrollment=courseService.enrollment(id,seats);
        if (courseEnrollment==null){
            return ResponseEntity.status(400).body(new ApiResponse("this course is not available for enrollment"));
        }
        return ResponseEntity.ok().body("The course seats has been updated:\n" + courseEnrollment);
    }



}
