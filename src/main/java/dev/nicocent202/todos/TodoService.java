package dev.nicocent202.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public void deleteTodoByTid(String tid) {
        todoRepository.deleteByTid(tid);
    }
    public Todo updateTodoByTid(String tid, Boolean checked){
        Optional<Todo> todo = todoRepository.findByTid(tid);
        if (todo.isPresent()){
            Todo todoAux = todo.get();
            todoAux.setChecked(checked);
            return todoRepository.save(todoAux);
        } else {
            return null;
        }

    }
}
