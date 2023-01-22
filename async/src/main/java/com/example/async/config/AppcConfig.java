package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AppcConfig {

    @Bean("async-thread")
    public Executor asyncThread(){
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setMaxPoolSize(100);
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setQueueCapacity(10);
        threadPoolExecutor.setThreadNamePrefix("Async-");
        // 10개 core > queue > core 다시 늘어남
        return threadPoolExecutor;

    }
}
