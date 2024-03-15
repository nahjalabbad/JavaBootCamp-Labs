package org.example.lab5_exercise3.Controller;

import org.example.lab5_exercise3.API.ApiResponse;
import org.example.lab5_exercise3.Model.EventSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventSystemController {
    ArrayList<EventSystem> events=new ArrayList<>();


    @GetMapping()
    public ArrayList<EventSystem> getEvents(){
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody EventSystem event){
        events.add(event);
        return new ApiResponse("Event has been added successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponse("Event has been deleted successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody EventSystem event){
        events.set(index,event);
        return new ApiResponse("Event has been updated successfully");
    }


    @PutMapping("/change/{id}")
    public ApiResponse changeCapacity(@PathVariable int id, @RequestParam int capacity){
        for (EventSystem e:events){
            if (e.getId()==id){
                if (capacity<0){
                    return new ApiResponse("Capacity cannot be less than 0");
                }
                e.setCapacity(capacity);
            }
        }
        return new ApiResponse("Capacity of "+id+" has been changed to "+capacity);
    }

    @GetMapping("/search/{id}")
    public ApiResponse searchEvent(@PathVariable int id){
        for (EventSystem e:events){
            if (e.getId()==id) {
                return new ApiResponse(e.toString());
            }
        }
        return new ApiResponse("no ID was found");
    }



}
