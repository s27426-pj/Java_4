package com.example.bookshop.feign.service;


import com.example.bookshop.feign.client.BookOrderClient;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookOrderService {

    private final BookOrderClient communicationClient;

    public Response printPdf() {
            return communicationClient.getBooksPdf();
    }
}
