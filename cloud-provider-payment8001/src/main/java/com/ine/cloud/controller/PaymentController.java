package com.ine.cloud.controller;


import com.ine.cloud.entities.Payment;
import com.ine.cloud.entities.Result;
import com.ine.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("create")
    public Result create(Payment payment) {
        int insert = paymentService.create(payment);
        log.info("插入数据库---");
        if (insert > 0) {
            return new Result(200,"成功",null);
        }
        return new Result(444,"失败",null);
    }

    @GetMapping("sel/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询payment---");
        if (null !=payment) {
            return Result.builder().code(200).msg("成功").data(payment).build();
        }

        return Result.builder().code(444).msg("失败，没有该ID："+id).build();
    }
}
