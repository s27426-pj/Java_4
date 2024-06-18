package com.example.bookshop.feign.service;

import com.example.bookshop.feign.client.BookOrderClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookOrderService {
    private final BookOrderClient communicationClient;

    public BookOrderService(BookOrderClient communicationClient) {
        this.communicationClient = communicationClient;
    }
    public ResponseEntity<byte[]> printPdf() {
            return communicationClient.getBooksPdf();
    }
}
