package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.dynamia.app.EnableDynamiaToolsApi;

/**
 * Backend entrypoint for the application. This class is responsible for
 * starting the Spring Boot application and enabling the Dynamia Tools API.
 */
@SpringBootApplication
@EnableDynamiaToolsApi
public class DemoApplication {

    static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
