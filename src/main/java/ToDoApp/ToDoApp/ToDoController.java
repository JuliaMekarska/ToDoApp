package ToDoApp.ToDoApp;

import ToDoApp.ToDoApp.ToDo;
import ToDoApp.ToDoApp.ToDoService;
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
    public String addToDo(@RequestBody String name) {
        return toDoService.addToDo(name);
    }

    @PutMapping("/{id}")
    public String updateToDo(@PathVariable int id) {
        return toDoService.updateToDo(id);
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable int id) {
        boolean deleted = toDoService.deleteToDo(id);
        return deleted ? "Task deleted" : "Task not found";
    }
}
