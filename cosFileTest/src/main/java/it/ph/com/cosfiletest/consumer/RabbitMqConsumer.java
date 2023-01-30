package it.ph.com.cosfiletest.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述： RabbitMq消费者
 */
@Component
public class RabbitMqConsumer {
    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述: 单列模式消费者
     * @RabbitListener 指定消费的队列
     **/
    @RabbitListener(queues = "queue_simple_Mode")
    public void simpleModeConsumer(String msg, Message message, Channel channel) {
        System.out.println("开始消费消息：" + msg);
    }

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述: 单列模式消费者(绑定交换机)
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
    public void bindingSimpleMode2(String msg, Message message, Channel channel) throws Exception {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        int a = 0;
        try {
            if (a < 10) {
                throw new RuntimeException("抛异常！");
            }
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            System.out.println("消费失败了将消息放回");
        }
        System.out.println("消费者3：" + msg);
    }

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述: Topic交换机绑定消费
     * @RabbitListener 指定消费的队列
     **/
    @RabbitListener(queues = "topic.binding_simple_mode_queue")
    public void topicSimpleMode(String msg, Message message, Channel channel) {
        System.out.println("topic消费者消费：" + msg);
    }

    @RabbitListener(queues = "topic.binding_simple_mode_queue2")
    public void topicSimpleMode2(String msg, Message message, Channel channel) {
        System.out.println("topic2消费者消费：" + msg);
    }

    /**
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述: 扇形交换机消费者
     **/
    @RabbitListener(queues = "fan_binding_simple_mode_queue")
    public void fanSimpleMode(String msg, Message message, Channel channel) {
        System.out.println("扇形交换机，消费者1：" + msg);
    }

    @RabbitListener(queues = "fan_binding_simple_mode_queue2")
    public void fanSimpleMode2(String msg, Message message, Channel channel) {
        System.out.println("扇形交换机，消费者2：" + msg);
    }

    @RabbitListener(queues = "fan_binding_simple_mode_queue3")
    public void fanSimpleMode3(String msg, Message message, Channel channel) {
        System.out.println("扇形交换机，消费者3：" + msg);
    }
}