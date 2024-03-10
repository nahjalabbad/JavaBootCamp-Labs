package org.example.lab5_exercise1.Controller;

import org.example.lab5_exercise1.API.ApiResponse;
import org.example.lab5_exercise1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/college")
public class StudentController {
    ArrayList<Student> students=new ArrayList<>();

    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return students;
    }

    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index){
        return students.get(index).getName();
    }

    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index){
        return students.get(index).getAge();
    }

    @GetMapping("/degree/{index}")
    public String getDegree(@PathVariable int index){
        return students.get(index).getDegree();
    }

    @GetMapping("/study/status/{index}")
    public ApiResponse status(@PathVariable int index) {
        try {
                if (students.get(index).isStatus()) {
                    return new ApiResponse("Graduated");
                } else {
                    return new ApiResponse("UnderGraduated");
                }

        } catch (IndexOutOfBoundsException e) {
            return new ApiResponse("index out of bound");
        }
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("Student added successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Student deleted successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student){
        students.set(index,student);
        return new ApiResponse("Student updated successfully");
    }


}
