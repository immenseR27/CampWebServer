package com.immenser.interserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InterServApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterServApplication.class, args);
    }

}
