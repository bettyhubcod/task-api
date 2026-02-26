package sn.isi.l3gl.api.task_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "sn.isi.l3gl.api.task_api",
        "sn.isi.l3gl.core.task_core"
})
@EntityScan(basePackages = {
        "sn.isi.l3gl.core.task_core.entite"
})
@EnableJpaRepositories(basePackages = {
        "sn.isi.l3gl.core.task_core"
})
public class TaskApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }
}