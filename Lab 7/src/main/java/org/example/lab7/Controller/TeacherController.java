package org.example.lab7.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab7.API.ApiResponse;
import org.example.lab7.Model.Teacher;
import org.example.lab7.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeachers() {
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        boolean isYear=teacherService.addTeacher(teacher);
        if (isYear) {
            return ResponseEntity.ok().body(new ApiResponse("Teacher has been added"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Year Of Recruitment cannot be less than 2000"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        boolean isUpdated = teacherService.updateTeacher(id, teacher);
        if (isUpdated) {
            return ResponseEntity.ok().body(new ApiResponse("Teacher has been updated"));
        }
            return ResponseEntity.badRequest().body(new ApiResponse("ID not found"));
        }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {
        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted) {
            return ResponseEntity.ok().body(new ApiResponse("Teacher has been deleted"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("ID not found"));
        }
    }

    @GetMapping("/getteacher/{id}")
    public ResponseEntity getTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacher(id);
        if (teacher == null) {
            return ResponseEntity.badRequest().body(new ApiResponse("ID not found"));
        }
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/getprofession/{id}")
    public ResponseEntity getTeacherProfession(@PathVariable int id) {
        String profession = teacherService.getTeacherProfession(id);
        if (profession == null) {
            return ResponseEntity.badRequest().body(new ApiResponse("ID not found"));
        }
        return ResponseEntity.ok().body(new ApiResponse("Teacher with ID "+id+" profession is: "+profession));
    }

    @GetMapping("/getbyprofession/{profession}")
    public ResponseEntity getTeachersByProfession(@PathVariable String profession) {
        ArrayList<Teacher> teachersByProfession = teacherService.getTeachersByProfession(profession);
        if (teachersByProfession==null) {
            return ResponseEntity.badRequest().body(new ApiResponse("There is no teacher with this profession was found"));
        }
        return ResponseEntity.ok(teachersByProfession);
    }

    @GetMapping("/getsalary/{minSalary}/{maxSalary}")
    public ResponseEntity getTeachersBySalary(@PathVariable double minSalary, @PathVariable double maxSalary) {
        ArrayList<Teacher> teachers = teacherService.getTeachersBySalary(minSalary,maxSalary);
        if (teachers==null) {
            return ResponseEntity.badRequest().body(new ApiResponse("There is no teachers with this salary were found "));
        }
        return ResponseEntity.ok(teachers);
    }


    @GetMapping("/searchsubject/{subjectName}")
    public ResponseEntity searchBySubjectName(@PathVariable String subjectName) {
        ArrayList<Teacher> teachersWithSubject = teacherService.searchBySubjectName(subjectName);
        if (teachersWithSubject.isEmpty()) {
            return ResponseEntity.badRequest().body(new ApiResponse("There is no teacher is teaching this subject"));
        }
        return ResponseEntity.ok(teachersWithSubject);
    }
}
