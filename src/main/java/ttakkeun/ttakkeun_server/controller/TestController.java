package ttakkeun.ttakkeun_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        return "Hello, ttakkeun!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        // health check용
        return "I'm healthy!";
    }
}
