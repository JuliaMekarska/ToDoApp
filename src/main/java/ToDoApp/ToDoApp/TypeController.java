package ToDoApp.ToDoApp;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    private final TypeRepository repo;

    public TypeController(TypeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Type> getAll() {
        return repo.findAll();
    }
}
