package com.example.server.example_server.controller;


import com.example.server.example_server.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    //RequestMapping으로 구현하기
    @RequestMapping(value = "/domain",method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    //RequestBody를 활용한 POST 메서드 구현
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " +map.getValue() + "\n");
        });
        return sb.toString();
    }
    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}