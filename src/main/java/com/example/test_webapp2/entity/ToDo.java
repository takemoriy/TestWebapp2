package com.example.test_webapp2.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    private Integer id;
    private String todo;
    private String detail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
