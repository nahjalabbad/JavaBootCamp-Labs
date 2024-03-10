package org.example.lab5_exercise2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTracker {
    private String title,description,companyName;
    private int id;
    private String status;
}
