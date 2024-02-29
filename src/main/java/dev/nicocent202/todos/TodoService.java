package dev.nicocent202.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> allTodos() {
        return todoRepository.findAll();
    }
    public Todo createTodo(String tid, String title, Boolean checked) {
        Todo todo = new Todo(tid, title, checked);
        return todoRepository.save(todo);
    }
}
