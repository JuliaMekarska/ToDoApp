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
                        new Type(null, "Work", List.of()),
                        new Type(null, "Personal", List.of()),
                        new Type(null, "Shopping", List.of()),
                        new Type(null, "Study", List.of())
                ));
            }
        };
    }
}
