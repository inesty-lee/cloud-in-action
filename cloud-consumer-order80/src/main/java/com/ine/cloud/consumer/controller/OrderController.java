package com.ine.cloud.consumer.controller;


import com.ine.cloud.commons.entities.Payment;
import com.ine.cloud.commons.entities.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    public static final String BASE_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;


    @PostMapping("create")
    public Result create(Payment payment) {
        return restTemplate.postForObject(BASE_URL+"/payment/create",payment,Result.class);
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(BASE_URL+"/payment/sel/"+id,Result.class);
    }
}
