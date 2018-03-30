package com.zuipin.product.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/product/msg")
    String msg();

    @Component
    static class ProductClientFallback implements ProductClient {

        @Override
        public String msg() {
            return "挂掉了";
        }
    }
}
