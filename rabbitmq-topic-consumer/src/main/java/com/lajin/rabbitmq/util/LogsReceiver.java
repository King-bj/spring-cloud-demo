package com.lajin.rabbitmq.util;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者 *
 * @author Administrator
 * RabbitListener bindings 绑定队列
 * QueueBinding 绑定队列详细配置
 *              value:绑定队列名词
 *              exchange：配置交换器
 *              key:路由键
 * @Queue   value:队列名称
 *          autoDelete: 是否是可删除的临时队列
 * @Exchange  value:交换器名称自定义
 *            type:指定具体的交换器类型
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.logs}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                key = "${mq.config.queue.logs.routing.key}"
        )
)
public class LogsReceiver {
    /**
     * 接收消息的方法。采用消息队列监听机制 *
     * @param msg
     */
    @RabbitHandler
    public void process(String msg) {
        System.out.println("logs receiver: " + msg);
    }
}
