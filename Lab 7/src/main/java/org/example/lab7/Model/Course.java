package org.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Course {
    @Min(2)
    @NotNull(message = "ID cannot be null")
    private int id;

    @NotEmpty(message = "Name cannot be null")
    @Size(min = 2,max = 20,message = "Name should be between 2 and 20")
    private String name;

    @NotEmpty(message = "Type cannot be null")
    @Size(min = 2)
    private String type;

    @NotNull(message = "duration cannot be null")
    private int durationMin;

    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 10, max = 300)
    private String description;


    @NotNull(message = "Enrollment cannot be null")
    @PositiveOrZero
    private int enrollmentSeats;


    private boolean enrollmentStatus;
}
