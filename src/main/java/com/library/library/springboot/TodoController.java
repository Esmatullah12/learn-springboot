package com.library.library.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todo-list")
    public String todoList(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUsername("esmat");
        modelMap.addAttribute("todos", todos);
        return "todoList";
    }
}
