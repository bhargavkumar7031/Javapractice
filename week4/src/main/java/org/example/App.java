package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"org/example"})
@EnableJpaRepositories(basePackages = "org/example/repository")
@EntityScan(basePackages = "org/example/classes")
public class App
{
    public static void main( String[] args ) {
       ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    }
}
