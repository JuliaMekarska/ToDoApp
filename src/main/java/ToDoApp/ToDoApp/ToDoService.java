package ToDoApp.ToDoApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//showToDo
//addToDo
//deleteToDo
//updateToDo - completed czy tak czy nie
public class ToDoService {
   public List<ToDo> listToDo=new ArrayList<ToDo>();
   private int id=0;

   public List<ToDo> showToDo(){
       return listToDo;
   }

    public String addToDo(String name){
       ToDo task=new ToDo(id,name,false);
       id++;
       listToDo.add(task);
       return "Task added";
    }
    public boolean deleteToDo(int id){
        return listToDo.removeIf(toDo -> toDo.getId()==id);
    }


    public String updateToDo(int id) {
        for (ToDo existingToDo : listToDo) {
            if (existingToDo.getId() == id) {
                existingToDo.setCompleted(true);
                return "Task Updated";
            }
        }
        return "ID not found";
    }
    


}


