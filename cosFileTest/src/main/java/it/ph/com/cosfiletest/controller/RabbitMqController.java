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
 * @描述： RabbitMQ接口层
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
     * @描述: 单列模式（不绑定交换机直接给队列发消息）
     **/
    @GetMapping("simple")
    public void simpleModeController(String msg) {
        rabbitMqService.simpleMode(msg);
    }

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述: 单列模式(直连型交换机_路由模式交换机发送消息给绑定的队列)
     **/
    @GetMapping("bindingSimple")
    public void bindingSimpleModeController(String msg) {
        rabbitMqService.bindingSimpleMode(msg);
    }

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述: Topic交换机绑定（主题交换机_通配符模式_交换机发送消息给绑定的队列或者是通配符匹配到的队列）
     **/
    @GetMapping("topicSimple")
    public void topicSimpleModeController(String msg) {
        //两个消费这都能消费（原因：在绑定交换机时消费者2用了 topic.# 来进行匹配）
        rabbitMqService.topicBindingSimpleMode(msg, RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE);
        //只有消费者2能进行消费（原因：这里使用的消费2的队列发送的消息，消费者1绑定交换机时，是指定的队列的）
        rabbitMqService.topicBindingSimpleMode(msg, RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE2);
    }

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述: 扇形交换机
     **/
    @GetMapping("fanSimple")
    public void fanSimpleModeController(String msg) {
        rabbitMqService.fanBindingSimpleMode(msg);
    }

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述: 消息推送到server_但是在server里找不到交换机(交换机不存在测试回调)
     **/
    @GetMapping("noExchange")
    public void noExchangeController(String msg) {
        rabbitMqService.noExchangeTest(msg);
    }

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述: 消息推送到server_找到交换机了_但是没找到队列(交换机没有绑定队列)
     **/
    @GetMapping("noQueueExchange")
    public void noQueueExchangeController(String msg) {
        rabbitMqService.noQueueExchange(msg);
    }
}