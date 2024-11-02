package com.FishPond;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.FishPond.Repository")
public class AdminComponentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminComponentApplication.class, args);
    }
}
