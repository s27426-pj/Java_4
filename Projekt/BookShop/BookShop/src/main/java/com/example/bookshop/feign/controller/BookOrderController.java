package com.example.bookshop.feign.controller;

import com.example.bookshop.feign.service.BookOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookOrderController {
    private final BookOrderService bookOrderService;

    public BookOrderController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }

    @GetMapping("/print")
    public ResponseEntity<byte[]> getPdf() {
        return bookOrderService.printPdf();
    }

}
