package org.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @NotNull(message = "category id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotEmpty(message = "post title cannot be empty")
    @Size(min = 5)
    @Column(columnDefinition = "varchar(25) not null")
    private String title;

    @NotEmpty(message = "content cannot be empty")
    @Size(min = 5)
    @Column(columnDefinition = "varchar(255) not null")
    private String content;

    @NotNull(message = "user id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @Column(columnDefinition = "DATE")
    private LocalDate publishDate;
}
