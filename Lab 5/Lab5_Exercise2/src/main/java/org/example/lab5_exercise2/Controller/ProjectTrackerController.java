package org.example.lab5_exercise2.Controller;

import org.example.lab5_exercise2.API.ApiResponse;
import org.example.lab5_exercise2.Model.ProjectTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/projecttracker")
public class ProjectTrackerController {

    ArrayList<ProjectTracker> trackers=new ArrayList<>();

    @GetMapping()
    public ArrayList<ProjectTracker> getTrackers(){
        return trackers;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody ProjectTracker tracker){
        trackers.add(tracker);
        return new ApiResponse("Project added succcessfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        trackers.remove(index);
        return new ApiResponse("Project deleted successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody ProjectTracker tracker){
        trackers.set(index,tracker);
        return new ApiResponse("Project updated successfully");
    }

    @PutMapping("/status/{id}")
    public ApiResponse changeStatus(@PathVariable int id, @RequestParam String status){
        for (ProjectTracker t:trackers){
            if (t.getId()==id) {
                if (Objects.equals(t.getStatus(), "done")) {
                    t.setStatus(status);
                    return new ApiResponse("Status has been changed");
                }
                if (Objects.equals(t.getStatus(), "not done")) {
                    t.setStatus(status);
                    return new ApiResponse("Status has been changed");
            }
        }
    }
        return new ApiResponse("ID not found");
        }

    @GetMapping("/search/{title}")
    public ApiResponse searchProject(@PathVariable String title){

            for (ProjectTracker t:trackers){
                if (t.getTitle().equalsIgnoreCase(title)) {
                    return new ApiResponse(t.toString());
                }
            } return new ApiResponse("Title not found");
    }

    @GetMapping("/displayall/{companyName}")
    public ArrayList<ProjectTracker> displayAll(@PathVariable String companyName){
        ArrayList<ProjectTracker> sameCompany=new ArrayList<>();
        try {
            for (ProjectTracker t:trackers){
                if (t.getCompanyName().equalsIgnoreCase(companyName)){
                    sameCompany.add(t);
                }
            }
            if (sameCompany.isEmpty()){
                System.out.println("No project found under this company name");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return sameCompany;
    }




}
