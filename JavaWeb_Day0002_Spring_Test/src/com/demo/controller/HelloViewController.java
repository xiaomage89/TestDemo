package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloViewController {
 
    @RequestMapping("/testView")
    public String testView(){
        //HelloView������ĸСд
        return "success";
    }
}

