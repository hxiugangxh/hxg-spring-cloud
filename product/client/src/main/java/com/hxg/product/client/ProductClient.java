package com.hxg.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
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
