package com.ptithcm.apihealthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class ApiHealthCareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiHealthCareApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/*").allowedOrigins("http://localhost:3000");
//                registry.addMapping("/api/admin/*").allowedOrigins("http://localhost:3000");
//            }
//        };
//    }
}
