package org.example.lab7.Service;


import org.example.lab7.Model.Teacher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;


@Service
public class TeacherService {
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public Boolean addTeacher(Teacher teacher) {
        if (teacher.getYearOfRecruitment() != null && teacher.getYearOfRecruitment().isBefore(LocalDate.of(2000, 1, 1))) {
        return false;
        }
        teachers.add(teacher);
        return true;
    }

    public boolean updateTeacher(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }

    public String getTeacherProfession(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                int yearsOfWork = LocalDate.now().getYear() - teacher.getYearOfRecruitment().getYear();
                if (yearsOfWork < 5) {
                    teacher.setProfessionName("Instructor");
                } else if (yearsOfWork < 10) {
                    teacher.setProfessionName("Assistant Professor");
                } else if (yearsOfWork < 15) {
                    teacher.setProfessionName("Associate Professor");
                } else {
                    teacher.setProfessionName("Professor");
                }
                return teacher.getProfessionName();
            }
        }
        return null;
    }


    public ArrayList<Teacher> getTeachersByProfession(String profession) {
        ArrayList<Teacher> teachersByProfession = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getProfessionName().equalsIgnoreCase(profession)) {
                teachersByProfession.add(teacher);
            }
        }
        if (teachersByProfession.isEmpty()){
            return null;
        }
        return teachersByProfession;
    }

    public ArrayList<Teacher> getTeachersBySalary(double minSalary,double maxSalary) {
        ArrayList<Teacher> bySalary = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getSalary() > minSalary&&teacher.getSalary()<maxSalary) {
                bySalary.add(teacher);
            }
        }
        if (bySalary.isEmpty()){
            return null;
        }
        return bySalary;
    }

    public ArrayList<Teacher> searchBySubjectName(String subjectName) {
        ArrayList<Teacher> teachersWithSubject = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getSubjectName().equalsIgnoreCase(subjectName)) {
                teachersWithSubject.add(teacher);
            }
        }
        if (teachersWithSubject.isEmpty()){
            return null;
        }
        return teachersWithSubject;
    }
}
