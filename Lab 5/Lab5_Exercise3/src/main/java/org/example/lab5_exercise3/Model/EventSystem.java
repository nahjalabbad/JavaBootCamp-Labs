package org.example.lab5_exercise3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class EventSystem {
    private int id,capacity;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate,endDate;
}
