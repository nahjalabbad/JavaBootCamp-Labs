package org.example.lab7.Model;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Teacher {
        @NotNull(message = "ID cannot be null")
        @Min(value = 2, message = "ID should be at least 2")
        private Integer id;

        @NotEmpty(message = "Name cannot be empty")
        @Size(min = 2, max = 20, message = "Name should be between 2 and 20")
        private String name;

        @NotEmpty(message = "Subject name cannot be empty")
        @Size(min = 3, message = "Subject name should have at least 3 characters")
        private String subjectName;

        @NotNull(message = "Year of recruitment cannot be null")
        @PastOrPresent()
        private LocalDate yearOfRecruitment;

        @NotNull(message = "Salary cannot be null")
        @Min(value = 4000, message = "Salary should be at least 4000")
        private Double salary;

        @Pattern(regexp = "^(Instructor|Assistant Professor|Associate Professor|Professor)$")
        private String professionName;
    }

