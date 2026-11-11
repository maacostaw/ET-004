package taskManager.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import taskManager.dtos.TaskDTO;
import taskManager.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskDTO create(@Valid @RequestBody TaskDTO taskDTO) {
        return taskService.create(taskDTO);
    }

    @GetMapping
    public List<TaskDTO> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO) {
        return taskService.update(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

    @PatchMapping("/{id}/status")
    public TaskDTO updateStatus(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.updateStatus(id, taskDTO.getStatus());
    }
}