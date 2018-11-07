package com.atguigu.rabbit.service;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class UserService {

    @RabbitListener(queues = {"atguigu","atguigu.news"})//可以监听多个
    public void hello(Message msg){
        //Message类型的
        System.out.println("收到的消息："+msg);
        byte[] body = msg.getBody();//消息内容
        MessageProperties messageProperties = msg.getMessageProperties();//消息属性
    }

    @RabbitListener(queues = {"gulixueyuan.news"})
    public void order(Channel channel) throws IOException {
        //Channel手工的确认回复消息是否收到了
        //channel.basicAck();//返回ack信息
        //channel.basicReject();//返回拒绝接受

        /*
        * long deliveryTag, boolean requeue//是否重新放入队列
        * */
        AMQP.Basic.Reject reject = new AMQP.Basic.Reject.Builder().build();
        long deliveryTag = reject.getDeliveryTag();
        channel.basicReject(deliveryTag,true);
        System.out.println("我拒接了消息！");
    }
}
