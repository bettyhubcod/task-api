package sn.isi.l3gl.api.task_api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.task_core.entite.Task;
import sn.isi.l3gl.core.task_core.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // Injection via constructeur
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // POST /api/tasks → créer une tâche
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task);
        return ResponseEntity.ok(created);
    }

    // GET /api/tasks → lister toutes les tâches
    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.listTasks());
    }

    // PUT /api/tasks/{id}/status → modifier le statut
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam String status) {
        taskService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    // GET /api/tasks/done/count → compter les tâches DONE
    @GetMapping("/done/count")
    public ResponseEntity<Long> countCompletedTasks() {
        return ResponseEntity.ok(taskService.countCompletedTasks());
    }
}