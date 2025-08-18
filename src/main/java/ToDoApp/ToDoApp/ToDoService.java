package ToDoApp.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    public ToDoRepository toDoRepository;

    public List<ToDo> showToDo() {
        return toDoRepository.findAll();
    }

    public String addToDo(String name) {
        ToDo task = new ToDo(name, false);
        toDoRepository.save(task);
        return "Task added";
    }

    public boolean deleteToDo(int id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String updateToDo(int id) {
        ToDo existingToDo = toDoRepository.findById(id).orElse(null);
        if (existingToDo != null) {
            existingToDo.setCompleted(true);
            toDoRepository.save(existingToDo);
            return "Task Updated";
        }
        return "ID not found";
    }
}


