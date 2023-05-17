package com.example.server.example_server.controller;


import com.example.server.example_server.dto.MemberDto;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //5.2.1 @RequestMapping으로 구현
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    //5.2.2 매개변수 없는 GET 메서드 구현
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    //5.2.3 @PathVaiable을 이용해 매개변수 전달
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }
    //기본적으론 @GETMapping어노테이션과 @PathVariable에 지정된 변수의 이름을 동일하게 맞춰야한다
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }//만약 @GETMapping어노테이션과 @PathVariable의 변수명을 맞추기 어렵다면 변수명을 지정한다

    // 5.2.4 @RequestParam를 이용해 쿼리 형식으로 값 전달
    @GetMapping("/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }//URI에서 ?를 기준으로 우측에 "{키}={값}" 형태로 구성된 요청을 전송하는 방법

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb= new StringBuilder();
        param.entrySet().forEach(map->{
            sb.append(map.getKey()+" : " +map.getValue()+"\n");
        });
        return sb.toString();
    }//매개변수 항목이 일정하지 않을 경우 Map 객체로 받는 것이 효율적 ex)ID같은 필수항목이 아닌 취미 같은 선택 항목

    // 5.2.5 DTO 객체를 활용한 GET 메서드 구현
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}