package com.atguigu.gmall.cart.controller;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Atest {
    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        String fieldOrder = JSON.toJSONString(ids);
        System.out.println(fieldOrder);
    }
}
