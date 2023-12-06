package com.mysite.SpringBootBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    //1) 500 오류코드, 아무런 값도 리턴하지 않기 때문에 오류가 발생한다.
//    @GetMapping("/sbb")
//    public void index() {
//        System.out.println("index");
//    }

    //2) @ResponseBody 애너테이션은 URL 요청에 대한 응답으로 문자열을 리턴
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 sbb에 오신것을 환영합니다.";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
