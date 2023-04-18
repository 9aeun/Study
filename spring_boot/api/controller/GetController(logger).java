// GetController에 Logger 기능을 추가.
// 이를 사용하려면 logback-Spring.xml의 15~28번 및 34번 줄을 지워 파일로 저장되는 로그는 없도록 설정을 변경한 후 진행.
// 이 Appender를 지우려면 따로 설정한 Root나 Logger 영역에서도 레퍼런스로 잡혀 있지는 않은지 확인한 후 제거해야함.
    
package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    
    //5.7.2 Logback 적용하기 (예제 5.26)
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //예제 5.27, 5.28
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        Logger.info("getHello 메서드가 호출되었습니다.");
        retrun "Hello World";
    }
    
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        Logger.info("getName 메서드가 호출되었습니다.");
        return "Flature"
    }
}
