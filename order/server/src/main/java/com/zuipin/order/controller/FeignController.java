package com.zuipin.order.controller;

import com.zuipin.product.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/orderTest")
    public String orderTest() {

        return "order is work";
    }

    @GetMapping("/productFegin")
    public String productFegin() {

        String msg = productClient.msg();

        return msg;
    }

}
