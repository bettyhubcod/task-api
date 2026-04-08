package sn.isi.l3gl.core.task_core.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.l3gl.core.task_core.entite.Task;
public interface TaskRepository extends JpaRepository<Task, Long> {
    long countByStatus(String status);
}