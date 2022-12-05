package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    //pages에 main에 접근하면 aaaa 폴더의 main.html의 내용을 리턴시킨다.
    @GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("aaaa/main");
    }
}
