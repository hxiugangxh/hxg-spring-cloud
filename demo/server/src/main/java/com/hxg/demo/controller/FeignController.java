package com.hxg.demo.controller;

import com.hxg.demo.base.result.RestResult;
import com.hxg.demo.base.result.ResultUtil;
import com.hxg.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FeignController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/productFegin")
    public RestResult productFegin() {

        log.info("feign");

        String msg = productClient.msg();

        return ResultUtil.success(msg);
    }

}
