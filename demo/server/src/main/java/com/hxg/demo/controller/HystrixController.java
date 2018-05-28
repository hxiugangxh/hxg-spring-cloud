package com.hxg.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// 手动降级代码
// 熔断代码
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @HystrixCommand
    @GetMapping("/timeOutStr2")
    public String timeOutStr2() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://localhost:8084/product/timeOutStr", String.class);
    }

    // 超时设置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"),
    })
    @GetMapping("/timeOutStr")
    public String timeOutStr(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://localhost:8084/product/timeOutStr", String.class);
    }

//    调用defaultFallback则不需要指定fallbackMethod
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProdocut")
    public String getProdocut() {

        // 抛出异常也可以出发降级代码
        //throw new RuntimeException("发送了异常");

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://localhost:8084/product/getStr", String.class);

    }

    private String fallback() {
        return "太拥挤了，请稍后再试~";
    }

    private String defaultFallback() {
        return "默认提示太拥挤了";
    }

}
