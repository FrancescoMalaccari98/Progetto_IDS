package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@ComponentScan(basePackages = {"application"})
@EnableJpaRepositories(basePackages = "application.repository")
@EntityScan(basePackages = "application.model")
public class mainClass {

    public static void main(String[] args) {
        SpringApplication.run(mainClass.class, args);
    }
}