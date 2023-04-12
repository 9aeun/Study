package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.Map;

// put api는 웹 애플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트 하는 데 사용
@RestController
@RequestMapping("api/v1/put-api")
public class PutController {

    //5.4.1 @RequestBody를 활용한 PUT 메서드 구현
    // http body에 담아 전달, 서버에 어떤 값이 들어올지 모르는 경우 Map 객체를 활용해 값을 받음
    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 PUT 메서드 구현
    //서버에 들어오는 요청에 담겨 있는 값이 정해져 있는 경우
    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMamberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    // 5.4.2 ResponseEntity를 활용한 PUT 메서드 구현
    // HttpEntity라는 클래스를 사용, 응답 코드 변경은 물론 Header와 Body를 더욱 쉽게 구성할 수 있음
    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
