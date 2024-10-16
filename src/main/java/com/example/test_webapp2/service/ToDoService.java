package com.example.test_webapp2.service;

import java.util.List;

import com.example.test_webapp2.entity.ToDo;

public interface ToDoService {
    List<ToDo> selectAll();
    ToDo selectById(Integer id);
    void insert(ToDo todo);
    void update(ToDo todo);
    void delete(Integer id);
}
