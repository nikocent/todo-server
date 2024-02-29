package dev.nicocent202.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<List<Todo>>(todoService.allTodos(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Map<String, Object> dataObject) {
        String tid = (String) dataObject.get("tid");
        String title = (String) dataObject.get("title");
        Boolean checked = (Boolean) dataObject.get("checked");
        return new ResponseEntity<Todo>(todoService.createTodo(tid, title, checked), HttpStatus.CREATED);
    }
}
