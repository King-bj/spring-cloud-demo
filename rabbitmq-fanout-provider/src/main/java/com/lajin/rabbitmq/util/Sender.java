package com.lajin.rabbitmq.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者 * @author Administrator *
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitAmqpTemplate; /* * 发送消息的方法 */

    @Value("${mq.config.exchange}")
    private String exchange;


    /**
     *  //向消息队列发送消息
     * @param msg 消息
     */
    public void send(String msg) {
        //参数一：交换器名称。
        //参数二：队列的名称
        //参数三：消息
       this.rabbitAmqpTemplate.convertAndSend(exchange,"",msg);

    }



}
