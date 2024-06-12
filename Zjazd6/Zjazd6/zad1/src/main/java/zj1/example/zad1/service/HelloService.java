package zj1.example.zad1.service;

import org.springframework.stereotype.Service;
import zj1.example.zad1.shared.CommunicationClient;

@Service
public class HelloService {
    private final CommunicationClient communicationClient;

    public HelloService(CommunicationClient communicationClient) {
        this.communicationClient = communicationClient;
    }
    public String HelloMessage() {
        try {
                return communicationClient.getHelloMessage();
        } catch (Exception e) {
            return "Wystąpił błąd podczas komunikacji: " + e.getMessage();
        }
    }
}
