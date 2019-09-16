# Class TestController 추가
+ GetMapping("/")에 "hello world" 반환
 
~~~java
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
~~~

+ 테스트를 위해 http://localhost:8080 호출
    + Hello World가 잘 출력 되는가?