package com.atguigu.rabbit.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderService {

    /**
     * 利用延迟队列，处理超时订单问题
     * @param order
     * @throws IOException
     */
    @RabbitListener(queues = "userOrderQueue")
    public void receiveOrder(Order order) throws IOException {
        System.out.println("收到了过期订单。。。"+order);
        /*String string = new String(order.getBody());
        Order readValue = new ObjectMapper().readValue(string, Order.class);*/

        //这里在应用中,判断是最新的订单状态
        if(order.getStatus()%2==0){
            System.out.println("此订单已支付，告诉库存系统去减库存");
        }else {
            System.out.println("此订单已经超时，而且还没支付，，，作废。。。。");
        }
    }
}
