package com.newer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LangController {
    @RequestMapping("/toEmp")
    public String toEmp(){
        return "emp";
    }
}
