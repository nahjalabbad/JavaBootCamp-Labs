package org.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @Min(2)
    @NotNull(message = "ID cannot be null")
    private int id;

    @NotEmpty(message = "Name cannot be null")
    @Size(min = 2,max = 20,message = "Name should be between 2 and 20")
    private String name;

    @NotNull(message = "Credit Hours cannot be null")
    @Max(300)
    private int creditHours;

    @NotNull(message = "GPA cannot be null")
    @PositiveOrZero
    private double GPA;

    @Pattern(regexp = "^(Freshman|Sophomore|Junior|Senior)$")
    private String studentClassification;
}
