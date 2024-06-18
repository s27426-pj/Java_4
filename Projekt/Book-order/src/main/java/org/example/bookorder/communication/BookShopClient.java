package org.example.bookorder.communication;

import org.example.bookorder.model.BookToOrderDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "BookShop", url = "http://localhost:8093")
public interface BookShopClient {

    @GetMapping("/bookshop/books_to_order")
    List<BookToOrderDetails> getBooksToOrder();

}
