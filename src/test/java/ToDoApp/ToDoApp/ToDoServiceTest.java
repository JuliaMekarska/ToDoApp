package ToDoApp.ToDoApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
    public class ToDoServiceTest {

        @Autowired
        private ToDoService toDoService;

        @Autowired
        private ToDoRepository toDoRepository;

        @BeforeEach
        public void setUp() {

            toDoRepository.deleteAll();
        }

        @Test
        public void testAddToDo() {
            // Given
            String taskName = "Test Task";

            // When
            String response = toDoService.addToDo(taskName);

            // Then
            assertEquals("Task added", response);
            List<ToDo> tasks = toDoService.showToDo();
            assertEquals(1, tasks.size());
            assertEquals(taskName, tasks.get(0).getName());
            assertFalse(tasks.get(0).isCompleted());
        }

        @Test
        public void testShowToDo() {

            toDoService.addToDo("Task 1");
            toDoService.addToDo("Task 2");


            List<ToDo> tasks = toDoService.showToDo();


            assertEquals(2, tasks.size());
            assertEquals("Task 1", tasks.get(0).getName());
            assertEquals("Task 2", tasks.get(1).getName());
        }

        @Test
        public void testDeleteToDo() {

            toDoService.addToDo("Task to delete");
            int taskId = toDoService.showToDo().get(0).getId();


            boolean result = toDoService.deleteToDo(taskId);


            assertTrue(result);
            assertEquals(0, toDoService.showToDo().size());
        }

        @Test
        public void testDeleteToDo_IfTaskNotFound() {

            int nonExistingId = 999;

            boolean result = toDoService.deleteToDo(nonExistingId);

            assertFalse(result);
        }

        @Test
        public void testUpdateToDo() {

            toDoService.addToDo("Task to update");
            int taskId = toDoService.showToDo().get(0).getId();

            String response = toDoService.updateToDo(taskId);

            assertEquals("Task Updated", response);
            assertTrue(toDoService.showToDo().get(0).isCompleted());
        }

        @Test
        public void testUpdateToDo_IfTaskNotFound() {

            int nonExistingId = 999;

            String response = toDoService.updateToDo(nonExistingId);

            assertEquals("ID not found", response);
        }

}
