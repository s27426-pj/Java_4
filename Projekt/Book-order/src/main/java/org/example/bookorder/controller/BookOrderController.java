package org.example.bookorder.controller;

import org.example.bookorder.service.BookOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookOrderController {
    private final BookOrderService bookOrderService;

    public BookOrderController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> getBooksPdf() {
        return bookOrderService.generateOrderPdf();
    }
}
