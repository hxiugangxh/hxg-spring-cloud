package com.hxg.simpledemo.controller;

import com.hxg.simpledemo.bean.People;
import com.hxg.simpledemo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public People people() {
        People people = new People();
        people.setName("张三");

        return people;
    }

    @GetMapping("/listPeople")
    public List<People> listPeople() {

        return peopleService.listPeople();
    }

}
