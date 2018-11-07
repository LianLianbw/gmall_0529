package com.atguigu.rabbit.controller;


import com.atguigu.rabbit.service.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("createOrder")
    public Order createOrder() throws JsonProcessingException {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString().substring(0,5));

        order.setStatus((int) (Math.random()*100));
        order.setTotalAmount(new BigDecimal("99.9"));

        /*MessageProperties messageProperties = new MessageProperties();
        //一分钟消息过期
        messageProperties.setExpiration(1000*60+"");
        //将对象转为json
        ObjectMapper objectMapper = new ObjectMapper();
        String asString = objectMapper.writeValueAsString(order);//序列化

        Message message = new Message(asString.getBytes(), messageProperties);*/

        //给延迟消息队列发送一个消息，说订单创建完成
        //MessagePostProcessor消息对象创建好之后,发之前可以设置消息的一些属性
        rabbitTemplate.convertAndSend("user_order_delay_exchange", "order_delay"
                , order, new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setExpiration(1000*60+"");
                        return message;
                    }
                });
        return order;
    }
}
