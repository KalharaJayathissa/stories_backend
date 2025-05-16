package com.storyweb.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.storyweb.backend.repository.StoryRepository;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
	 @Bean
    CommandLineRunner runner(StoryRepository repository) {
        return args -> {
            System.out.println("Connected to MongoDB Atlas. Stories in DB: " + repository.count());
        };
    }
}
