package com.zuipin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableCircuitBreaker
@ComponentScan(basePackages = {
		"com.zuipin.demo",
		"com.zuipin.product.client"
})
@EnableFeignClients(basePackages = {
		"com.zuipin.product.client"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
