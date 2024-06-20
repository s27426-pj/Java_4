package com.example.bookshop.feign.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Book-order", url = "http://localhost:8092")
public interface BookOrderClient {

    @GetMapping("/pdf")
    Response getBooksPdf();

}