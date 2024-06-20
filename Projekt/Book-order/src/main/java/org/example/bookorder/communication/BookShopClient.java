package org.example.bookorder.communication;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "BookShop", url = "http://localhost:8093", configuration = FeignConfig.class)
public interface BookShopClient {

    @GetMapping(value = "/bookshop/books_to_order", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Response> getBooksToOrder();

}
