package com.example.test_webapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.test_webapp2.entity.ToDo;
import com.example.test_webapp2.service.ToDoService;

import lombok.RequiredArgsConstructor;


@SpringBootApplication
@RequiredArgsConstructor
public class TestWebapp2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestWebapp2Application.class, args);
	}

/*
	private final ToDoService service;

	public void exe() {
		// ★全件検索
		System.out.println("全件検索");
		service.selectAll().forEach(System.out::println);
		// ★1件検索
		System.out.println("1件検索");
		System.out.println(service.selectById(1));
		// ★新規登録
		System.out.println("新規登録");
		service.insert(new Todo(null, "新規登録", "新規登録の詳細", null, null));
		System.out.println(service.selectById(4));
		// ★更新
		System.out.println("更新");
		service.update(new Todo(4, "更新", "更新の詳細", null, null));
		System.out.println(service.selectById(4));
		// ★削除
		System.out.println("削除");
		service.delete(4);
		service.selectAll().forEach(System.out::println);
	}
*/
}
