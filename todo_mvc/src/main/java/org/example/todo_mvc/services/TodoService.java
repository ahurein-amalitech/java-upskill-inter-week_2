package org.example.todo_mvc.services;

import org.example.todo_mvc.entities.Todo;
import org.example.todo_mvc.repository.JpaTodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final JpaTodoRepository repository;

    public TodoService(JpaTodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo){
        return repository.save(todo);
    }

    public Todo getTodoById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Todo> getAllTodos(){
        return repository.findAll();
    }

    public Todo markTodoAsCompleted(Long id){
        Todo todo = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        todo.setCompleted(true);
        repository.save(todo);
        return todo;
    }
}
