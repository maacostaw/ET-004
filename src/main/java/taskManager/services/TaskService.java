package taskManager.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import taskManager.exceptions.ResourceNotFoundException;
import taskManager.dtos.TaskDTO;
import taskManager.entities.Task;
import taskManager.enumns.Status;
import taskManager.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    public TaskDTO create(TaskDTO taskDTO) {
        Task task = modelMapper.map(taskDTO, Task.class);
        Task saved = taskRepository.save(task);
        return modelMapper.map(saved, TaskDTO.class);
    }

    public List<TaskDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .toList();
    }

    public TaskDTO findById(Long id) {
        Task task = getTaskOrThrow(id);
        return modelMapper.map(task, TaskDTO.class);
    }

    public TaskDTO update(Long id, TaskDTO taskDTO) {
        Task existing = getTaskOrThrow(id);
        existing.setTitulo(taskDTO.getTitulo());
        existing.setDescripcion(taskDTO.getDescripcion());
        existing.setStatus(taskDTO.getStatus());
        existing.setDueDate(taskDTO.getDueDate());
        Task updated = taskRepository.save(existing);
        return modelMapper.map(updated, TaskDTO.class);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO updateStatus(Long id, Status status) {
        Task existing = getTaskOrThrow(id);
        existing.setStatus(status);
        Task updated = taskRepository.save(existing);
        return modelMapper.map(updated, TaskDTO.class);
    }

    private Task getTaskOrThrow(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }
}