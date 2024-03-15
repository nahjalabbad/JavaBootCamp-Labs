package org.example.lab5_exercise1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name,degree;
    private int age;
    private boolean status;
}
