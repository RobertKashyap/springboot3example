package com.springboot3example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        SpringApplication.run(Main.class, args);// starts a basic tomcat server
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse("Hello");
    }

    // POJO blueprint to return JSON data via rest annotation (via jackson library, json parser for java)
    record GreetResponse(String greet) {
    }
}
