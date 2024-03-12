package org.example.lab6.Controller;

import jakarta.validation.Valid;
import org.example.lab6.API.ApiResponse;
import org.example.lab6.Model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    ArrayList<Employee>employees=new ArrayList<>();

    

    @GetMapping("/get")
    public ResponseEntity getEmployees(){
        return ResponseEntity.ok().body(employees);
    }


    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        if (!employee.getPosition().matches("^(supervisor|coordinator)$")) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid position, must be supervisor or coordinator."));
        }

        if (!(employee.getHireDate().getYear()>1900)) {
            return ResponseEntity.status(400).body(new ApiResponse("Hire date must be1900 or later"));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee has been added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Integer id, @RequestBody @Valid Employee employee, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (employee.getId().equals(id)){
            int index=0;
            for (Employee e:employees){
                index=employees.indexOf(e);
            }
            employees.set(index,employee);
            return ResponseEntity.status(200).body(new ApiResponse("Employee has been updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable int id){
            int index;
            for (Employee e:employees){
                if (e.getId().equals(id)){
                index=employees.indexOf(e);
                employees.remove(index);
                return ResponseEntity.status(200).body(new ApiResponse("Employee has been deleted"));
            }
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }


    @GetMapping("position/{position}")
    public ResponseEntity searchByPositon(@PathVariable String position){
        ArrayList<Employee>byPosition=new ArrayList<>();
        for (Employee e:employees){
            if (e.getPosition().equalsIgnoreCase(position)){
                byPosition.add(e);
            }
        }
        if (byPosition.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("there is no employees under the position: "+position));
        }
        return ResponseEntity.status(200).body(byPosition);

    }


    @GetMapping("/age/{minAge}/{maxAge}")
    public ResponseEntity searchByAge(@PathVariable Integer minAge, @PathVariable Integer maxAge){
        ArrayList<Employee>byAge=new ArrayList<>();
        for (Employee e:employees){
            if (e.getAge()>=minAge&&e.getAge()<=maxAge){
                byAge.add(e);
            }
        }
        if (byAge.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("there is no employees between "+minAge+" and "+maxAge));
        }
        return ResponseEntity.status(200).body(byAge);

    }


    @PutMapping("/apply/{id}")
    public ResponseEntity applyAnnual(@PathVariable Integer id){

        for (Employee e:employees) {
            if (e.getId().equals(id)) {
                if (!e.isOnLeave() && e.getAnnualLeave() > 1) {
                    e.setOnLeave(true);
                    e.setAnnualLeave(e.getAnnualLeave() - 1);
                    return ResponseEntity.status(200).body(new ApiResponse("Employee status has been changed to on leave"));
                }
                return ResponseEntity.status(400).body(new ApiResponse("employee have no annual leave left"));

            }
        }
        return ResponseEntity.status(400).body(new ApiResponse("no ID found"));
    }


    @PutMapping("/noleave/{onLeave}")
    public ResponseEntity noLeave(@PathVariable boolean onLeave) {
        ArrayList<Employee> noleave = new ArrayList<>();

        for (Employee e : employees) {
            if (!onLeave && !e.isOnLeave()) {
                noleave.add(e);
            }
        }

        if (noleave.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("there is no employees with this criteria found "));
        }

        return ResponseEntity.status(200).body(noleave);
    }


    @PostMapping("/promote/{idSuper}/{idEmp}")
    public ResponseEntity promoteEmployee(@PathVariable Integer idSuper, @PathVariable Integer idEmp) {
        Employee supervisor = null;
        Employee employee = null;
        for (Employee emp : employees) {
            if (emp.getId().equals(idSuper) && emp.getPosition().equalsIgnoreCase("supervisor")) {
                supervisor = emp;
            }
            if (emp.getId().equals(idEmp)) {
                employee = emp;
            }
        }
        if (supervisor == null) {
            return ResponseEntity.status(400).body(new ApiResponse("The Employee with ID " + idSuper + " is not a supervisor"));
        }
        if (employee == null) {
            return ResponseEntity.status(400).body(new ApiResponse("No Employee found with ID " + idEmp));
        }
        if (employee.getAge() >= 30 && !employee.isOnLeave()) {
            employee.setPosition("supervisor");
            return ResponseEntity.status(200).body(new ApiResponse("The Employee with ID " + idSuper + " has promoted the Employee with ID " + idEmp + " to a supervisor."));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("The Employee with ID " + idEmp + " does not meet the promotion criteria."));
        }
    }

}



