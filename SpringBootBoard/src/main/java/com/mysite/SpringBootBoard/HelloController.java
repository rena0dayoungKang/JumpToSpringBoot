package com.mysite.SpringBootBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody   //hello 메서드의 응답 결과가 문자열 그 자체. 문자열을 return
    public String hello() {
        return "Hello SpringBootBoard";
    }
}
