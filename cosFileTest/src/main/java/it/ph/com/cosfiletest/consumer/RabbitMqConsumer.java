package it.ph.com.cosfiletest.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：RabbitMq消费者
 */
@Component
public class RabbitMqConsumer {
    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消费者
     * @RabbitListener 指定消费的队列
     **/
    @RabbitListener(queues = "queue_simple_Mode")
    public void simpleModeConsumer(String msg, Message message, Channel channel) {
        System.out.println("开始消费消息：" + msg);
    }

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消费者(绑定交换机)
     * @RabbitListener 指定消费的队列
     **/
    @RabbitListener(queues = "queue_binding_simple_mode")
    public void bindingSimpleMode(String msg, Message message, Channel channel) {
        System.out.println("消费者1：" + msg);
    }

    @RabbitListener(queues = "queue_binding_simple_mode")
    public void bindingSimpleMode1(String msg, Message message, Channel channel) {
        System.out.println("消费者2：" + msg);
    }

    @RabbitListener(queues = "queue_binding_simple_mode")
    public void bindingSimpleMode2(String msg, Message message, Channel channel) {
        System.out.println("消费者3：" + msg);
    }

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:Topic交换机绑定消费
     * @RabbitListener 指定消费的队列
     **/
    @RabbitListener(queues = "topic.binding_simple_mode_queue")
    public void topicSimpleMode(String msg, Message message, Channel channel) {
        System.out.println("topic消费这消费：" + msg);
    }

    @RabbitListener(queues = "topic.binding_simple_mode_queue2")
    public void topicSimpleMode2(String msg, Message message, Channel channel) {
        System.out.println("topic2消费这消费：" + msg);
    }

}