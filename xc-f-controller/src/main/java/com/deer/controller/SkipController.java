package com.deer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1/page")
@Controller
public class SkipController {

    @RequestMapping("index")
    public String getIndex(){
        return "index";
    }
    @RequestMapping("login")
    public String getLogin(){
        return "login";
    }

}
