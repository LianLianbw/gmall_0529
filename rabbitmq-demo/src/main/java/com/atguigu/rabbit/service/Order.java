package com.atguigu.rabbit.service;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Order implements Serializable {
    private String orderId;//订单号
    private Integer status;//订单状态
    private BigDecimal totalAmount;//订单的金额
}
