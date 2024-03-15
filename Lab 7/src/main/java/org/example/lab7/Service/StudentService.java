package org.example.lab7.Service;

import org.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public boolean updateStudents(int id, Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student student(int id){
        for (Student student:students){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }
    public String getStudentClassification(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                if (student.getCreditHours() < 30) {
                    student.setStudentClassification("Freshman");
                } else if (student.getCreditHours() < 60) {
                    student.setStudentClassification("Sophomore");
                } else if (student.getCreditHours() < 90) {
                    student.setStudentClassification("Junior");
                } else {
                    student.setStudentClassification("Senior");
                }
                return student.getStudentClassification();
            }
        }
        return null;
    }


        public ArrayList<Student> getStudentsByGPA(double minGPA) {
            ArrayList<Student> getGPA = new ArrayList<>();
            boolean GPA = false;
            for (Student student : students) {
                if (student.getGPA() > minGPA) {
                    getGPA.add(student);
                    GPA=true;
                }
            }
            if (!GPA) {
                return null;
            }
            return getGPA;
        }

    public ArrayList<String> getStudentsNames(char letter) {
        ArrayList<String> getNames = new ArrayList<>();
        boolean isName = false;
        char searchLetter = Character.toLowerCase(letter);

        for (Student student : students) {
            char firstLetter = Character.toLowerCase(student.getName().charAt(0));
            if (firstLetter == searchLetter) {
                getNames.add(student.getName());
                isName = true;
            }
        }

        if (!isName) {
            return null;
        }
        return getNames;
    }

}

