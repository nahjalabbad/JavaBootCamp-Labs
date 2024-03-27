package org.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "username cannot be empty")
    @Size(min=5)
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Size(min = 6, max = 20)
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @Email
    @NotEmpty(message = "email cannot be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate registrationDate;
}
