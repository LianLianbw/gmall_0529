package com.atguigu.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class GmallRabbitConfig {

    /*
    * Queue、Exchange、Binding只要放在容器中,SpringBoot都会自动的给Rabbitmq创建出这些东西
    * 如果rabbitMQ已经有了，就不用创建了
    * @return
    * */

    /**
     * 1.创建一个用户订单的延迟队列
     * @return
     */
    @Bean
    Queue userOrderDelayQueue(){
        //给队列指定延迟规则
        //1.这个队列的里面的信死了去哪里？
        //2.死了以后用哪个路由键发出去
        Map<String,Object> map = new HashMap<>();
        //x-dead-letter-exchange 声明了队列里的死信转发到的 DLX(死信交换机Dead letter Exchange) 名称
        map.put("x-dead-letter-exchange","user.order.exchange");
        //x-dead-letter-routing-key 声明了队列里的死信转发时携带的 routing-key 名称
        map.put("x-dead-letter-routing-key","order");
        Queue queue = new Queue("user_order_delay_queue", true, false, false,map);

        return queue;
    }

    /**
     * 2、创建一个延迟交换机
     * @return
     */
    @Bean
    Exchange userOrderDelayExchange(){
        return new DirectExchange("user_order_delay_exchange",true,false,null);
    }

    /**
     * 将延迟交换机和延迟队列绑定
     * @return
     */
    @Bean
    Binding userOrderDelayExchangeQueueBinding(){
        Binding order_delay = BindingBuilder.bind(userOrderDelayQueue())
                .to(userOrderDelayExchange())
                .with("order_delay")
                .noargs();
        return order_delay;
    }

    //============以上创建了一个延迟队列和交换机和绑定关系==============


    //============创建接受死信的Exchange(DXL)============
    @Bean
    Exchange userOrderExchange(){
        return new DirectExchange("user.order.exchange");
    }

    //创建一个存在死信的队列
    @Bean
    Queue userOrderQueue(){
        return new Queue("userOrderQueue");
    }

    //创建绑定关系
    @Bean
    Binding userOrderExchangeQueueBinding(){
        Binding order = BindingBuilder.bind(userOrderQueue())
                .to(userOrderExchange())
                .with("order")
                .noargs();
        return order;
    }


    /*
    * 标配
    * 定制消息转换的规则，以json的方式
    * */
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }
}
