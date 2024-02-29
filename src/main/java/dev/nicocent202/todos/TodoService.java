package dev.nicocent202.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

}
