package org.example.helloapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HelloappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloappApplication.class, args);
    }

}
