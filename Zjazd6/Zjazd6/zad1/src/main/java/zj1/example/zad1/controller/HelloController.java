package zj1.example.zad1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zj1.example.zad1.login.AdminPermission;
import zj1.example.zad1.service.HelloService;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @AdminPermission
    @GetMapping("/Hello")
    public String getHelloMessagePass() {
        return helloService.HelloMessage();
    }
}
