package com.todoapp.controller;

import com.todoapp.model.Todo;
import com.todoapp.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/todos")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> allTodo() {
        List<Todo> todos = todoService.getAllTodo();

        return ResponseEntity.ok(todos);
    }

    @PostMapping("/")
    public ResponseEntity<List<Todo>> saveTodo(@RequestBody Todo todo) {

        List<Todo> todoResponse = todoService.saveTodo(todo);

        return ResponseEntity.ok(todoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Todo>> updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        List<Todo> todoResponse = todoService.updateTodo(id, todo);

        return ResponseEntity.ok(todoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
        Todo todo = todoService.deleteTodoById(id);

        return ResponseEntity.ok("Todo deleted successfully");
    }
}
