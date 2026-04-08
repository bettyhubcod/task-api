package sn.isi.l3gl.core.task_core.service;
import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.task_core.entite.Task;
import sn.isi.l3gl.core.task_core.repository.TaskRepository;
import java.util.List;
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task createTask(Task task) { return taskRepository.save(task); }
    public List<Task> listTasks() { return taskRepository.findAll(); }
    public void updateStatus(Long id, String status) {
        taskRepository.findById(id).ifPresent(t -> { t.setStatus(status); taskRepository.save(t); });
    }
    public long countCompletedTasks() { return taskRepository.countByStatus("DONE"); }
}