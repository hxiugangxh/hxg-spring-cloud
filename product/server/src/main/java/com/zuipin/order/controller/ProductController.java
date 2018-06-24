package com.zuipin.order.controller;

import com.zuipin.order.bean.ProductBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/timeOutStr")
    public String timeOutStr() {

        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "自定义尝试时间，default_executionTimeoutInMilliseconds = 1000;默认为1s哟";
    }

    @GetMapping("/getStr")
    public String getStr() {

        return "返回字符串";
    }

    @GetMapping("/listProduct")
    public List<ProductBean> listProduct() {
        List<ProductBean> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductBean productBean = new ProductBean();
            productBean.setName("商品" + i);
            productBean.setMoney(i * 10);
            productBean.setDesc("商品描述" + i);

            productList.add(productBean);
        }

        return productList;
    }

}
