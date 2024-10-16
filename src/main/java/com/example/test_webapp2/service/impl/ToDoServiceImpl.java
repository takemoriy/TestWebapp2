package com.example.test_webapp2.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test_webapp2.entity.ToDo;
import com.example.test_webapp2.repository.ToDoMapper;
import com.example.test_webapp2.service.ToDoService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoMapper toDoMapper;

    @Override
    public List<ToDo> selectAll() {
        return toDoMapper.selectAll();
    }

    @Override
    public ToDo selectById(Integer id) {
        return toDoMapper.selectById(id);
    }

    @Override
    public void insert(ToDo todo) {
        toDoMapper.insert(todo);
    }

    @Override
    public void update(ToDo todo) {
        todo.setUpdatedAt(LocalDateTime.now()); // 更新日時を設定
        toDoMapper.update(todo);
    }

    @Override
    public void delete(Integer id) {
        toDoMapper.delete(id);
    }
}