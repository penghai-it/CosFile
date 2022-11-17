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
        System.out.println("开始发送消息了");
        rabbitTemplate.convertAndSend(RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_EXCHANGE, key, msg, message -> {
            message.getMessageProperties().setMessageId(String.valueOf(UUID.randomUUID()));
            return message;
        });
    }


    public void fanBindingSimpleMode(String msg) {
        System.out.println("扇形交换机开始发送消息了");
        rabbitTemplate.convertAndSend(RabbitMqConstant.FAN_BINDING_SIMPLE_MODE_EXCHANGE, null, msg, message -> {
            message.getMessageProperties().setMessageId(String.valueOf(UUID.randomUUID()));
            return message;
        });
    }

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:消息推送到server_但是在server里找不到交换机(交换机不存在测试回调)
     **/
    public void noExchangeProducer(String msg, String key) {
        System.out.println("交换机不存在时发送消息,测试回调!!");
        rabbitTemplate.convertAndSend("non-existent-exchange", key, msg, message -> {
            message.getMessageProperties().setMessageId(String.valueOf(UUID.randomUUID()));
            return message;
        });
    }

    public void noQueueExchange(String msg, String key) {
        System.out.println("交换机存但未绑定队列,测试回调!!");
        rabbitTemplate.convertAndSend(RabbitMqConstant.NO_QUEUE_TEST_EXCHANGE, key, msg, message -> {
            message.getMessageProperties().setMessageId(String.valueOf(UUID.randomUUID()));
            return message;
        });
    }
}
