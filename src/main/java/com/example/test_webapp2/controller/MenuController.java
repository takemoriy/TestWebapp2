package com.example.test_webapp2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    // ★メニュー画面を表示します。
    @GetMapping("/")
    public String showMenu() {
        return "menu";
    }

}