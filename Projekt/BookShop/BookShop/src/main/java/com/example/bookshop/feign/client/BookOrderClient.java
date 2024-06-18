package com.example.bookshop.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Book-order", url = "http://localhost:8092")
public interface BookOrderClient {

    @GetMapping("/pdf")
    ResponseEntity<byte[]> getBooksPdf();

}