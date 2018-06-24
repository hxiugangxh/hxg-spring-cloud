package com.hxg.simpledemo.mq;

import com.hxg.simpledemo.bean.People;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/sendMq", produces = { "application/json;charset=UTF-8" })
    public People sendMq() {

        amqpTemplate.convertAndSend("myQueue", new Date());

        People people = new People();

        people.setName("张三");

        return people;
    }


}
