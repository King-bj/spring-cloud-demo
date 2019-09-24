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

    @Value("${mq.config.queue.info.routing.key}")
    private String infokey;

    @Value("${mq.config.queue.error.routing.key}")
    private String errorkey;



    /**
     *  //向消息队列发送消息
     * @param msg 消息
     * @param type 消息类型
     */
    public void send(String msg,String type) {
        //参数一：交换器名称。
        //参数二：队列的名称
        //参数三：消息
        if("info".equals(type)){
            this.rabbitAmqpTemplate.convertAndSend(exchange,infokey,msg);
        }else if("error".equals(type)){
            this.rabbitAmqpTemplate.convertAndSend(exchange,errorkey,msg);
        }

    }



}
