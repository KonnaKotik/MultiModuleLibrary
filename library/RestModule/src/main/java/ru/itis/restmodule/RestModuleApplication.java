package ru.itis.restmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"ru.itis.logicmodule.repository"})
@EntityScan(basePackages = {"ru.itis.logicmodule.model"})
@SpringBootApplication
@ComponentScan(basePackages = {"ru.itis.logicmodule", "ru.itis.restmodule"})
public class RestModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestModuleApplication.class, args);
    }

}
