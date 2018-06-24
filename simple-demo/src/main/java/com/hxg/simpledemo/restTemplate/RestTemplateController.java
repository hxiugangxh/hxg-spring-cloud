package com.hxg.simpledemo.restTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class RestTemplateController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/tmpMsg")
    public String tmpMsg() {
        return "it is msg";
    }

    @GetMapping("/getTmpMsg")
    public String getTmpMsg() {
        // 第一种方式
       /* RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/tmpMsg";
        String msg = restTemplate.getForObject(url , String.class);

        log.info("getTmpMsg: {}", msg);*/

        // 第二种方式
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("simple-demo");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
        RestTemplate restTemplate = new RestTemplate();
        log.info("url = " + url);
        String msg = restTemplate.getForObject(url, String.class);*/

        //第三种方式
       String msg =  restTemplate.getForObject("http://simple-demo/msg", String.class);
        log.info("getTmpMsg: {}", msg);

        return msg;
    }

}
