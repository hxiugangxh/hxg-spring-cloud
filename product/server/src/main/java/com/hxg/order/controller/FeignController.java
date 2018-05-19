package com.hxg.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @GetMapping("/productFegin")
    public String productFegin() {

        String msg = "123";
        return msg;
    }

    @GetMapping("/msg")
    public String msg() {

        String msg = "it is from product msg new";
        return msg;
    }

}
