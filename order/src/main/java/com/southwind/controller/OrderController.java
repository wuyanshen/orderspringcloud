package com.southwind.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyanshen
 * @date 2020-02-07 4:29 下午
 * @discription 控制器
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("index")
    public String index(){
        return "order的端口是："+this.port;
    }
}
