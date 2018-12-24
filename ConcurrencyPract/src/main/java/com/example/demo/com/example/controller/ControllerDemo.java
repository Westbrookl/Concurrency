package com.example.demo.com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jhc on 2018/12/24
 */

@Controller

@RequestMapping(value = "/",method= RequestMethod.GET)
public class ControllerDemo {
    @ResponseBody
    @RequestMapping(value="test",method=RequestMethod.GET)
    public String test(){
        return "test";
    }
}
