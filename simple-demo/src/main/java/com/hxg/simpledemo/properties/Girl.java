package com.hxg.simpledemo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
@PropertySource("classpath:/girl.properties")
@Data
public class Girl {
    private String name;
    private Integer age;
}
