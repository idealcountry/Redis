package com.spacetim.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author spacetim
 * @date 2021/9/24
 * @description
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "info")
    public String hello(@RequestParam(value = "userId", required = false) String username){
        return "hello," + username + " this is your "+
                "world";
    }

    @RequestMapping("date")
    public String date(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        System.out.println(date);
        return "now time is " + date;
    }


}
