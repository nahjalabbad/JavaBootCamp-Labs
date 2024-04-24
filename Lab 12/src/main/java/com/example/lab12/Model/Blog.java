package com.example.lab12.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;

    @NotEmpty(message = "title cannot be empty")
    @Column(columnDefinition = "varchar(30)")
    private String title;

    @NotEmpty(message = "body cannot be empty")
    @Column(columnDefinition = "varchar(255)")
    private String body;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;


}
