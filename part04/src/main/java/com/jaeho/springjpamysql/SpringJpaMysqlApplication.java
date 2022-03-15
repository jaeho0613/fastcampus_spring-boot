package com.jaeho.springjpamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJpaMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaMysqlApplication.class, args);
    }

}
