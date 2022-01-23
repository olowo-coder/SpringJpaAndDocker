package com.example.springjpaanddocker;

import com.example.springjpaanddocker.model.AuditorAwareImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@OpenAPIDefinition
@Slf4j
public class SpringJpAandDockerApplication {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringJpAandDockerApplication.class, args);
    }

}
