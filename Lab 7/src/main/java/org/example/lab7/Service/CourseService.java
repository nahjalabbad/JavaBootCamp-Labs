package org.example.lab7.Service;

import jakarta.validation.constraints.Pattern;
import org.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course>courses=new ArrayList<>();
    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addCourses(Course course){
        courses.add(course);
    }

    public boolean updateCourses(int id, Course course){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId()==id){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId()==id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course>searchByType(String type){
        ArrayList<Course>getByType=new ArrayList<>();
        boolean found=false;
        for (Course c:courses){
            if (c.getType().equalsIgnoreCase(type)){
                getByType.add(c);
                found=true;
            }
        }
        if (!found){
            return null;
        }
        return getByType;
    }

    public Course getCourse(int id){
        for (Course c:courses){
            if (c.getId()==id){
                return c;
            }
        }
        return null;
    }


    public boolean availability(int id, boolean available){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.get(i).setEnrollmentStatus(available);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> availableCourses(boolean available){
        ArrayList<Course>availableCourses=new ArrayList<>();
        boolean availability=false;
        for (Course c:courses){
            if (c.isEnrollmentStatus()==available){
                availableCourses.add(c);
                availability=true;
            }
        }
        if (!availability){
            return null;
        }
        return availableCourses;
    }

    public Course enrollment(int id, int seats) {
        Course course = null;
        for (Course c : courses) {
            if (c.getId() == id && c.isEnrollmentStatus() && c.getEnrollmentSeats() >= seats) {
                if (c.getEnrollmentSeats() > seats) {
                    c.setEnrollmentSeats(c.getEnrollmentSeats() - seats);
                } else {
                    c.setEnrollmentSeats(0);
                    c.setEnrollmentStatus(false);
                }
                course = c;
                break;
            }
        }
        return course;
    }



}
