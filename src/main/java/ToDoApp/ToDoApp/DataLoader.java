package ToDoApp.ToDoApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(TypeRepository typeRepo) {
        return args -> {
            if (typeRepo.count() == 0) {
                typeRepo.saveAll(List.of(
                        new Type(0, "Work", null),
                        new Type(0, "Personal", null),
                        new Type(0, "Shopping", null),
                        new Type(0, "Study", null)
                ));
            }
        };
    }
}
