package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tools.dynamia.app.EnableDynamiaToolsApi;
import tools.dynamia.navigation.Module;
import tools.dynamia.navigation.ModuleProvider;

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

    /**
     * A minimal starter needs at least one {@link ModuleProvider} bean: DynamiaTools'
     * {@code ModuleContainer} requires a non-empty {@code List<ModuleProvider>} at startup.
     * Replace this with your own module(s)/page(s) as the app grows — {@code List<ModuleProvider>}
     * injection is additive, so you can keep this one around or remove it once you add real modules.
     */
    @Bean
    ModuleProvider homeModuleProvider() {
        return () -> new Module("home", "Home");
    }

}
