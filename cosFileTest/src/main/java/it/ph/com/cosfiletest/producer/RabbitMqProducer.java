package it.ph.com.cosfiletest.producer;

import it.ph.com.cosfiletest.constant.RabbitMqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：RabbitMq生产者
 */
@Component
public class RabbitMqProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * @param msg 消息
     * @param key 队列key
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消息发送给指定消费这消费
     **/
    public void simpleMode(String msg, String key) {
        System.out.println("开始发送消息");
        rabbitTemplate.convertAndSend(key, msg);
    }

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消息发送给指定消费这消费(绑定交换机)
     **/
    public void bindingSimpleMode(String msg, String key) {
        System.out.println("绑定交换机,开始发送消息了");
        rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_BINDING_SIMPLE_MODE, key, msg, message -> {
            message.getMessageProperties().setMessageId(String.valueOf(UUID.randomUUID()));
            return message;
        });
    }

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:Topic交换机绑定
     **/
    public void topicBindingSimpleMode(String msg, String key) {
        System.out.println(key + ",开始发送消息了");
        rabbitTemplate.convertAndSend(RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_EXCHANGE, key, msg, message -> {
            message.getMessageProperties().setMessageId(String.valueOf(UUID.randomUUID()));
            return message;
        });
    }
}
