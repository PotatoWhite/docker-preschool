# 목표
 - 단순한 Spring Boot Application을 만든다.
 - 해당 Application을 이미지화 한다(dockerize) 
 
## Spring boot Application
 - dependency : web, lombok
 
### Test Controller 추가
 
~~~java
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
~~~ 


### Dockerfile 생성
- docker 이미지 빌드를 위해 생성

~~~dockerfile
FROM openjdk:11
VOLUME /tmp
ADD build/libs/demo-preschool-dockerize-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
~~~

## Build
1. Gradle을 이용해 springboot application을 build 함
~~~
gradle build
> 결과로 {project_home}/build/libs/demo-preschool-dockerize-0.0.1-SNAPSHOT.jar 생성 됨
~~~

2. docker를 이용해 Dockerfile을 빌드 함
~~~
docker build . -t demo-preschool-dockerize:0.0.1
> 결과로 docker images 에서 demo-preschool-dockerize 이미지가 출력되어야 함
~~~

## 실행
~~~
docker run -p 8081:8080 --name docker-preschool-01 demo-preschool-dockerize:0.0.1
~~~

## 실행확인
- 브라우져에서 localhost:8081 로 접속

## docker hub에 등록
+ docker hub login(없으면 계정만드세요)
~~~
docker login
~~~
+ docker hub에 등록 정보 설정
~~~
docker tag demo-preschool-dockerize:0.0.1 {your_dockerhub_id}/demo-preschool-dockerize:0.0.1
~~~
+ docker hub에 push
~~~
docker push {your_dockerhub_id}/demo-preschool-dockerize:0.0.1
~~~