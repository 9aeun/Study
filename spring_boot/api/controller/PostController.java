package com.springboot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러 클래스에서 공통 URL 설정
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //@RequestMapping으로 구현, GET API와 크게 다르지 않음
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }
}

