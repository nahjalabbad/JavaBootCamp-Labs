package org.example.lab6.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull(message = "ID cannot be empty")
    @Min(2)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min=4)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^05\\d{8}$",message = "Phone number must be 10 digits and start with 05")
    private String phoneNumber;

    @NotNull(message = "age cannot be empty")
    @Min(25)
    private Integer age;

    @NotEmpty(message = "position cannot be empty")
    @Pattern(regexp ="^(supervisor|coordinator)$",message = "Invalid position, must be supervisor or coordinator.")
    private String position;

    private boolean onLeave=false;

    @NotNull(message = "date cannot be empty")
    @PastOrPresent()
    private LocalDate hireDate;

    @NotNull(message = "annual leave cannot be empty")
    @PositiveOrZero
    private Integer annualLeave;

}
