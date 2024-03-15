package org.example.lab7.Controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab7.API.ApiResponse;
import org.example.lab7.Model.Student;
import org.example.lab7.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.ok().body(new ApiResponse("Student has been added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = studentService.updateStudents(id, student);
        if (isUpdated) {
            return ResponseEntity.ok().body(new ApiResponse("Student has been updated"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("ID not found"));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.ok().body(new ApiResponse("Student has been deleted"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("ID not found"));
        }
    }

    @GetMapping("/getstudent/{id}")
    public ResponseEntity searchByType(@PathVariable int id){
        Student byID=studentService.student(id);
        if (byID==null){
            return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
        }
        return ResponseEntity.ok().body(byID);
    }

    @GetMapping("/searchstatus/{id}")
    public ResponseEntity getStudentClassification(@PathVariable int id) {
        String status = studentService.getStudentClassification(id);
        if (status == null) {
            return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
        }
            return ResponseEntity.ok().body(new ApiResponse("The student with ID"+id+"Classifies as "+status));
    }

    @GetMapping("/getgpa/{minGPA}")
    public ResponseEntity getStudentsByGPA(@PathVariable double minGPA) {
        ArrayList<Student> students = studentService.getStudentsByGPA(minGPA);
        if (students == null) {
            return ResponseEntity.badRequest().body(new ApiResponse("no students with this GPA were found"));
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getname/{letter}")
    public ResponseEntity getStudentsNames(@PathVariable char letter) {
        ArrayList<String> names = studentService.getStudentsNames(letter);
        if (names == null) {
            return ResponseEntity.badRequest().body(new ApiResponse("no student name starting with the letter "+letter+" was found"));
        }
        return ResponseEntity.ok(names);
    }
}
