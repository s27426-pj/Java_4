package org.example.helloapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Hello", url = "http://localhost:8090")
public interface HelloClient {
    @GetMapping("/hello")
    String getHelloMessagePass();

}