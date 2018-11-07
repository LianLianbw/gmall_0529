package com.atguigu.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDemoApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	/*
	* 排他方式的消息队列
	* 一个队列可以被多个消费者所监听：消息到达后消费p2p抢消息；
	*
	* 只有一个指定的连接可以消费我这个队列，其他人都不可以
	* */
	@Test
	public void createQueue(){
		/*Queue queue = new Queue("hello-queue");
		amqpAdmin.declareQueue(queue);
		System.out.println("队列被创建了");*/

		/*Exchange exchange = new DirectExchange("hello-exchange");
		amqpAdmin.declareExchange(exchange);
		System.out.println("交换机创建了");*/
		/*String destination, Binding.DestinationType destinationType,
		String exchange, String routingKey, Map<String, Object> arguments*/
		Binding binding = new Binding("hello-queue",Binding.DestinationType.QUEUE,
				"hello-exchange","hello.msg",null);
		amqpAdmin.declareBinding(binding);
	}

	@Test
	public void contextLoads() {
		rabbitTemplate.convertAndSend("gmall.exchange.direct","atguigu.news","你好，今天天气真好。。。");
	}

}
