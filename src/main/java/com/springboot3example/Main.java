package com.springboot3example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//provides spring MVC features
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        SpringApplication.run(Main.class, args);// starts a basic tomcat server
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello",
                new Person("Robert", 24, 30_000.05),
                List.of("java", "ASM", "Bfck"));
        return response;
    }

    // POJO blueprint to return JSON data via rest annotation (via jackson library,
    // json parser for java)
    record GreetResponse(
            String greet,
            Person person,
            List<String> favProgLang) {
    }

    record Person(String name, int age, double savings) {
    }
}
