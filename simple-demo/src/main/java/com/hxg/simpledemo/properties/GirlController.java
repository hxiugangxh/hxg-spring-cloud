package com.hxg.simpledemo.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Autowired
    private Girl girl;

    @Autowired
    private Boy boy;

    @GetMapping("/girl")
    public Girl girl() {

        return girl;
    }

    @GetMapping("/boy")
    public Boy boy() {

        return boy;
    }


}
