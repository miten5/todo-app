package com.todoapp.service;

import com.todoapp.model.Todo;
import com.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
    @NoArgsConstructor
    @AllArgsConstructor
    public class TodoService {

        @Autowired
        private TodoRepository todoRepository;

        public List<Todo> getAllTodo() {
            List<Todo> todos = new ArrayList<>();

            todoRepository.findAll().forEach(todos::add);

            return todos;
        }

        public List<Todo> saveTodo(Todo todo) {
            return Collections.singletonList(todoRepository.save(todo));
        }

        public List<Todo> updateTodo(Integer id, Todo updated_todo) {
            Todo todo = todoRepository.findById(id).orElseThrow();

            todo.setTitle(updated_todo.getTitle());
            todo.setDescription(updated_todo.getDescription());
            todo.setPriority(updated_todo.getPriority());
            todo.setDueAt(updated_todo.getDueAt());
            todo.setReminderAt(updated_todo.getReminderAt());
            todo.setCompleted(updated_todo.getCompleted());

            return Collections.singletonList(todoRepository.save(todo));
        }

        public Todo deleteTodoById(Integer id) {
            Optional<Todo> todo = todoRepository.findById(id);
            todo.ifPresent(todoRepository::delete);

            return todo.orElse(null);
        }
    }
