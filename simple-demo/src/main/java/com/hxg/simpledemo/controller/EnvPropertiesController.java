package com.hxg.simpledemo.controller;

import com.hxg.simpledemo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/sysconf")
public class EnvPropertiesController {

    @Value("${env}")
    private String env;

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/print")
    public String print() {
        return env;
    }

}
