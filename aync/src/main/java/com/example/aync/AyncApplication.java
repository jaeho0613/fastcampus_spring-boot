package com.example.aync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyncApplication.class, args);
    }

}
