package me.potato.demopreschooldockerize;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/")
    public ResponseEntity get(){

        log.info("[REQ] Greeting");

        var greeting = "Hello World";


        return ResponseEntity.status(HttpStatus.OK).body(greeting);
    }
}
