package com.example.aync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class WebConfig {

    @Bean("async-thread")
    public Executor asyncThread() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setMaxPoolSize(100);
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setQueueCapacity(10);
        threadPoolExecutor.setThreadNamePrefix("Async-");

        return threadPoolExecutor;
    }
}
