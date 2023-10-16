package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample")
    public String sample(){
//        return "/WEB-INF/sample.jsp";
        return "sample";
    }
}
