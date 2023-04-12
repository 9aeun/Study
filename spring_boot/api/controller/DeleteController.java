package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // 5.5.1 PathVarilable과 @RequestParam을 활용한 DELETE 메서드 구현
    // @PathVariable 활용
    // http://localhost:8080//api/v1/delete-api/{String 값}
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    // @RequestParam 활용
    // http://localhost:8080//api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail : " + email;
    }

    // 5.6 REST API 명세를 문서화 하는 방법 - Swagger
    // 명세 : 해당 API가 어떤 로직을 수행하는지 설명하고 이 로직을 수행하기 위해 어떤 값을 요청하며, 이에 따른 응답값으로는 무엇을 받을 수 있는지를 정리한 자료형

}
