package com.lajin.rabbitmq;

import com.lajin.rabbitmq.util.OrderSender;
import com.lajin.rabbitmq.util.ProductSender;
import com.lajin.rabbitmq.util.Sender;
import com.lajin.rabbitmq.util.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    private OrderSender orderSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private UserSender userSender;

    @Test
    public void contextLoads() {
    }

    /* * 测试消息队列 */
    @Test
    public void test1() {
        this.orderSender.send("Order RabbitMQ");
        this.productSender.send("Product RabbitMQ");
        this.userSender.send("user RabbitMQ");
    }

}
