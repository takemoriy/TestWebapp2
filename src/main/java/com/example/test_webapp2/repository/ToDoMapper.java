package com.example.test_webapp2.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test_webapp2.entity.ToDo;

@Mapper
public interface ToDoMapper {
    List<ToDo> selectAll();
    ToDo selectById(@Param("id") Integer id);
    void insert(ToDo todo);
    void update(ToDo todo);
    void delete(@Param("id") Integer id);
}