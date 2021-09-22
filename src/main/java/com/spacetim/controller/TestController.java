package com.spacetim.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,String> test(){
        Map<String, String> map = new HashMap<>();

        map.put("name", "liuhaicheng");

        return map;

    }
}
