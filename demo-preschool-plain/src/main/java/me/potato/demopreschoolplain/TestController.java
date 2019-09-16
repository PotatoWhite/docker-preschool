package me.potato.demopreschoolplain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public ResponseEntity getHello() {
        String greeting = "Hello World";
        return ResponseEntity.status(HttpStatus.OK).body(greeting);
    }

}
