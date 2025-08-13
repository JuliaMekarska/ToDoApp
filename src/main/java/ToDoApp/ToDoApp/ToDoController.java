package ToDoApp.ToDoApp;

import ToDoApp.ToDo;
import ToDoApp.ToDoService;
import ToDoApp.ToDo;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    public final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> showToDo() {
        return toDoService.showToDo();
    }

    @PostMapping
    public String addToDo(@RequestBody ToDo name) {
        return toDoService.addToDo(name);
    }

    @PutMapping
    public String updateToDo(@RequestBody ToDo id) {
        return toDoService.updateToDo(id);
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable int id) {
        boolean deleted = toDoService.deleteToDo(id);
        return deleted ? "Task deleted" : "Task not found";
    }
}
