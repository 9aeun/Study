package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello

    // 5.2.1 @RequestMapping으로 구현
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello world";
    }

    // 5.2.2 매개변수가 없는 GET 메서드 구현
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    //5.2.3 @PathVariable을 활용한 Get 메서드 구현
    @GetMapping(value = "/variable1/{variable}") // 실무에선 대부분 매개변수를 받음, 이건 매개변수를 URL 자체에 값을 담아 요청
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // 5.2.3 @PathVariable에 지정한 변수의 이름과 메서드 매개변수의 이름을 동일하게 맞추기 어려울 때,
    // @GetMapping 어노테이션의 변수명을 지정
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // 5.2.4 @RequestParam을 이용한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // 5.2.4 쿼리스트링에 어떤 값이 들어올지 모를 때 Map 객체 활용
    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ": " + map.getValue() + "\n");
        });

        return sb.toString();
    }
}
