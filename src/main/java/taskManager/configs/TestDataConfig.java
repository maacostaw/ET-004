package taskManager.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import taskManager.entities.Task;
import taskManager.enumns.Status;
import taskManager.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class TestDataConfig {

    @Bean
    public CommandLineRunner initData(TaskRepository taskRepository) {
        return args -> {
            Task task1 = new Task();
            task1.setTitulo("Tarea 1");
            task1.setDescripcion("Descripción tarea 1");
            task1.setStatus(Status.PENDING);
            task1.setDueDate(LocalDateTime.now().plusDays(1));

            Task task2 = new Task();
            task2.setTitulo("Tarea 2");
            task2.setDescripcion("Descripción tarea 2");
            task2.setStatus(Status.IN_PROGRESS);
            task2.setDueDate(LocalDateTime.now().plusDays(3));

            Task task3 = new Task();
            task3.setTitulo("Tarea 3");
            task3.setDescripcion("Descripción tarea 3");
            task3.setStatus(Status.COMPLETED);
            task3.setDueDate(LocalDateTime.now().plusDays(5));

            taskRepository.saveAll(List.of(task1, task2, task3));
        };
    }
}