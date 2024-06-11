package zj1.example.zad1.shared;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "helloapp", url = "http://localhost:8090")
public interface CommunicationClient {

    @GetMapping("/hello")
    String getHelloMessage();

}