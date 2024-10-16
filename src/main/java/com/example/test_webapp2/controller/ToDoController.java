package com.example.test_webapp2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.test_webapp2.entity.ToDo;
import com.example.test_webapp2.form.ToDoForm;
import com.example.test_webapp2.helper.ToDoHelper;
import com.example.test_webapp2.service.ToDoService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;


@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    private final ToDoService toDoService;

    // ★「すること」の一覧を表示します。
    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", toDoService.selectAll());
        return "todo/list";
    }

    // ★指定されたIDの「すること」の詳細を表示します。
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
        //「すること」IDに対応する「すること」情報を取得して、modelに設定します。
        ToDo todo = toDoService.selectById(id);
        if(todo != null) {
            model.addAttribute("todo", todo);
            return "todo/detail";
        } else {
            // 対象データがない場合はフラッシュメッセージを設定して、一覧画面にリダイレクトします。
            attributes.addFlashAttribute("message", "対象データがありません。");
            return "redirect:/todos";
        }
    }

    // ★「すること」の新規登録画面を表示します。
    @GetMapping("/form")
    public String newToDo(@ModelAttribute ToDoForm form) {
        // 新規登録画面の設定
        form.setIsNew(true);
        return "todo/form";
    }

    // ★「すること」の新規登録処理を行います。
    @PostMapping("/save")
    public String create(@Validated @ModelAttribute ToDoForm form,BindingResult bindingResult, RedirectAttributes attributes) {
        logger.debug("save called with toDoForm: {}", form);
        // 入力チェック
        if(bindingResult.hasErrors()) {
            // エラーがある場合は新規登録画面の設定
            form.setIsNew(true);
            return "todo/form";
        }
        // エンティティに変換
        ToDo todo = ToDoHelper.convertToDo(form);
        // 新規登録処理
        toDoService.insert(todo);
        // フラッシュメッセージを設定して、一覧画面にリダイレクトします。
        attributes.addFlashAttribute("message", "新しいToDoが作成されましました。");
        // PRGパターン
        return "redirect:/todos";
    }

    // ★ 指定されたIDの編集画面を表示します。
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
        //「すること」IDに対応する「すること」情報を取得して、modelに設定します。
        ToDo todo = toDoService.selectById(id);
        if(todo != null) {
            // エンティティからフォームに変換
            ToDoForm form = ToDoHelper.convertToDoForm(todo);
            // モデルに格納
            model.addAttribute("toDoForm", form);
            return "todo/form";
        } else {
            // 対象データがない場合はフラッシュメッセージを設定して、一覧画面にリダイレクトします。
            attributes.addFlashAttribute("message", "対象データがありません。");
            return "redirect:/todos";
        }
    }

    // ★ 指定されたIDの更新処理を行います。
    @PostMapping("/update")
    public String update(@Validated ToDoForm form, BindingResult bindingResult, RedirectAttributes attributes) {
        // 入力チェック
        if(bindingResult.hasErrors()) {
            // エラーがある場合は編集画面の設定
            form.setIsNew(false);
            return "todo/form";
        }
        // エンティティに変換
        ToDo todo = ToDoHelper.convertToDo(form);
        // 更新処理
        toDoService.update(todo);
        // フラッシュメッセージを設定して、一覧画面にリダイレクトします。
        attributes.addFlashAttribute("message", "ToDoが更新されました。");
        // PRGパターン
        return "redirect:/todos";
    }

    // ★ 指定されたIDの削除処理を行います。
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        // 削除処理
        toDoService.delete(id);
        // フラッシュメッセージを設定して、一覧画面にリダイレクトします。
        attributes.addFlashAttribute("message", "ToDoが削除されました。");
        // PRGパターン
        return "redirect:/todos";
    }
}
