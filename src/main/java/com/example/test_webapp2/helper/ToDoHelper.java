package com.example.test_webapp2.helper;

import com.example.test_webapp2.entity.ToDo;
import com.example.test_webapp2.form.ToDoForm;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToDoHelper {
    private static final Logger logger = LoggerFactory.getLogger(ToDoHelper.class);
    
    // ToDoFormからToDoEntityへの変換
    public static ToDo convertToDo(ToDoForm form) {
        logger.debug("convertToDo called with form: {}", form);
        ToDo todo = new ToDo();
        todo.setId(form.getId());
        todo.setTodo(form.getTodo());
        todo.setDetail(form.getDetail());
        
        if (form.getIsNew()) {
            todo.setCreatedAt(LocalDateTime.now());
            todo.setUpdatedAt(null);
        } else {
            todo.setCreatedAt(form.getCreatedAt());
            todo.setUpdatedAt(LocalDateTime.now());
        }
        
        logger.debug("convertToDo result: {}", todo);
        return todo;
    }

    // ToDoEntityからToDoFormへの変換
    public static ToDoForm convertToDoForm(ToDo todo) {
        ToDoForm form = new ToDoForm();
        form.setId(todo.getId());
        form.setTodo(todo.getTodo());
        form.setDetail(todo.getDetail());
        form.setCreatedAt(todo.getCreatedAt());
        form.setUpdatedAt(todo.getUpdatedAt());
        
        // 更新画面設定
        form.setIsNew(false);
        return form;
    }

}
