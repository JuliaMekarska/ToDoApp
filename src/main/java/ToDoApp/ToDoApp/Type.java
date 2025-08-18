package ToDoApp.ToDoApp;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Type {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("type")
    private List<ToDo> taskList = new ArrayList<>();

    public Type() {}

    public Type(int id, String name, List<ToDo> taskList) {
        this.id = id;
        this.name = name;
        this.taskList = taskList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ToDo> getTaskList() {
        return taskList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskList(List<ToDo> taskList) {
        this.taskList = taskList;
    }

    public void addTask(ToDo task) {
        taskList.add(task);
        task.setType(this);
    }

    public void removeTask(ToDo task) {
        taskList.remove(task);
        task.setType(null);
    }
}
