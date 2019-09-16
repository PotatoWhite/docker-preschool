package me.potato.demopreschooldockercompose;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/")
    public ResponseEntity get() {
        var greeting = "Hello World";
        log.info("[REQ] greeting");
        return ResponseEntity.status(HttpStatus.OK).body(greeting);
    }
}
