package ToDoApp.ToDoApp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("type")   // unika pętli JSON
    private List<ToDo> taskList = new ArrayList<>();

    public Type() {}

    public Type(Integer id, String name, List<ToDo> taskList) {
        this.id = id;
        this.name = name;
        this.taskList = taskList;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<ToDo> getTaskList() {
        return taskList;
    }
    public void setTaskList(List<ToDo> taskList) {
        this.taskList = taskList;
    }

    // helpery
    public void addTask(ToDo task) {
        taskList.add(task);
        task.setType(this);
    }

    public void removeTask(ToDo task) {
        taskList.remove(task);
        task.setType(null);
    }
}
