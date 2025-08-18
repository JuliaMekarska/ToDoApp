package ToDoApp.ToDoApp;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    private final ToDoRepository todoRepo;
    private final TypeRepository typeRepo;

    public ToDoController(ToDoRepository todoRepo, TypeRepository typeRepo) {
        this.todoRepo = todoRepo;
        this.typeRepo = typeRepo;
    }

    @GetMapping
    public List<ToDo> getAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo todo) {
        if (todo.getType() != null) {
            var type = typeRepo.findById(todo.getType().getId())
                               .orElseThrow(() -> new RuntimeException("Type not found"));
            todo.setType(type);
        }
        return todoRepo.save(todo);
    }

    @PutMapping("/{id}")
    public ToDo toggle(@PathVariable int id) {
        var todo = todoRepo.findById(id).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
        return todoRepo.save(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        todoRepo.deleteById(id);
    }
}