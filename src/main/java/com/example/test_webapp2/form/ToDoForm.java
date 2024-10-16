package com.example.test_webapp2.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.cglib.core.Local;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {
    private Integer id;
    @NotBlank(message = "ToDoは必須です。")
    private String todo;
    @Size(min = 1, max = 100, message = "詳細は{min}～{max}文字以下です。")
    private String detail;
    private Boolean isNew = true; // デフォルトは新規登録
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
