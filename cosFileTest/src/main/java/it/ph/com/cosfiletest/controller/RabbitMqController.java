package it.ph.com.cosfiletest.controller;

import it.ph.com.cosfiletest.constant.RabbitMqConstant;
import it.ph.com.cosfiletest.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：RabbitMQ接口层
 */
@RestController
@RequestMapping("mq")
public class RabbitMqController {
    @Autowired
    RabbitMqService rabbitMqService;

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式
     **/
    @GetMapping("simple")
    public void simpleModeController(String msg, String key) {
        rabbitMqService.simpleMode(msg, key);
    }

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式(绑定交换机)
     **/
    @GetMapping("bindingSimple")
    public void bindingSimpleModeController(String msg, String key) {
        rabbitMqService.bindingSimpleMode(msg, key);
    }

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:Topic交换机绑定
     **/
    @GetMapping("topicSimple")
    public void topicSimpleModeController(String msg) {
        //两个消费这都能消费（原因：在绑定交换机时消费者2用了 topic.# 来进行匹配）
        rabbitMqService.topicBindingSimpleMode(msg, RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE);
        //只有消费者2能进行消费（原因：这里使用的消费这个2的队列发送的消息，消费者1绑定交换机时，是指定的队列的）
        rabbitMqService.topicBindingSimpleMode(msg, RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE2);
    }
}