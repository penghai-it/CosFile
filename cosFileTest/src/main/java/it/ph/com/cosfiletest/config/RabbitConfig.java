package it.ph.com.cosfiletest.config;

import it.ph.com.cosfiletest.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static it.ph.com.cosfiletest.constant.RabbitMqConstant.KEY_BINDING_SIMPLE_MODE;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：RabbitMQ配置类
 */
@Configuration
public class RabbitConfig {
    /**
     * @return: org.springframework.amqp.core.Queue
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式队列
     **/

    @Bean
    public Queue simpleModeQueue() {
        return new Queue("queue_simple_Mode");
    }

    /**
     * @return: org.springframework.amqp.core.Queue
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:创建队列
     **/
    @Bean
    public Queue queueBindingSimpleMode() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        // return new Queue("TestDirectQueue",true,true,false);
        //一般设置一下队列的持久化就好,其余两个就是默认fals
        return new Queue(RabbitMqConstant.QUEUE_BINDING_SIMPLE_MODE, true);
    }

    /**
     * @return: org.springframework.amqp.core.DirectExchange
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:创建交换机
     **/
    @Bean
    DirectExchange exchangeBindingSimpleMode() {
        //  return new DirectExchange("TestDirectExchange",true,true);
        return new DirectExchange(RabbitMqConstant.EXCHANGE_BINDING_SIMPLE_MODE, true, false);
    }

    /**
     * @return: org.springframework.amqp.core.Binding
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:绑定将队列和交换机绑定并设置用于匹配键：RabbitMqConstant.KEY_BINDING_SIMPLE_MODE
     **/
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(queueBindingSimpleMode()).to(exchangeBindingSimpleMode()).with(KEY_BINDING_SIMPLE_MODE);
    }

    /**
     * @return: org.springframework.amqp.core.Queue
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:Topic交换机绑定
     **/
    @Bean
    public Queue topicQueueBindingSimpleMode() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        // return new Queue("TestDirectQueue",true,true,false);
        //一般设置一下队列的持久化就好,其余两个就是默认fals
        return new Queue(RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE);
    }

    @Bean
    public Queue topicQueueBindingSimpleMode2() {
        return new Queue(RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE2);
    }

    /**
     * @return: org.springframework.amqp.core.DirectExchange
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:创建交换机(Topic交换机)
     **/
    @Bean
    TopicExchange topicExchangeBindingSimpleMode() {
        //  return new DirectExchange("TestDirectExchange",true,true);
        return new TopicExchange(RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_EXCHANGE);
    }

    /**
     * @return: org.springframework.amqp.core.Binding
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:将topicQueueBindingSimpleMode()和topicExchangeBindingSimpleMode()绑定_而且绑定的键值为_RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE_这样只要是消息携带的路由键是topic.man才会分发到该队列
     **/
    @Bean
    Binding topicBindingDirect() {
        return BindingBuilder.bind(topicQueueBindingSimpleMode()).to(topicExchangeBindingSimpleMode()).with(RabbitMqConstant.TOPIC_BINDING_SIMPLE_MODE_QUEUE);
    }

    /**
     * @return: org.springframework.amqp.core.Binding
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:将topicQueueBindingSimpleMode2()和topicExchangeBindingSimpleMode()绑定而且_绑定的键值为用上通配路由键规则topic.#_这样只要是消息携带的路由键是以topic.开头都会分发到该队列
     **/
    @Bean
    Binding topicBindingDirect2() {
        return BindingBuilder.bind(topicQueueBindingSimpleMode2()).to(topicExchangeBindingSimpleMode()).with("topic.#");
    }

    /**
     * @return: org.springframework.amqp.core.Queue
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:扇形交换机队列
     **/
    @Bean
    Queue fanSimpleModeQueue() {
        return new Queue(RabbitMqConstant.FAN_BINDING_SIMPLE_MODE_QUEUE);
    }

    /**
     * @return: org.springframework.amqp.core.Queue
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:扇形交换机队列2
     **/
    @Bean
    Queue fanSimpleModeQueue2() {
        return new Queue(RabbitMqConstant.FAN_BINDING_SIMPLE_MODE_QUEUE2);
    }

    /**
     * @return: org.springframework.amqp.core.Queue
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:扇形交换机队列3
     **/
    @Bean
    Queue fanSimpleModeQueue3() {
        return new Queue(RabbitMqConstant.FAN_BINDING_SIMPLE_MODE_QUEUE3);
    }

    /**
     * @return: org.springframework.amqp.core.FanoutExchange
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:扇形交换机
     **/
    @Bean
    FanoutExchange fanExchangeBindingSimpleMode() {
        return new FanoutExchange(RabbitMqConstant.FAN_BINDING_SIMPLE_MODE_EXCHANGE);
    }

    /**
     * @return: org.springframework.amqp.core.Binding
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:就队列1绑定到扇形交换机（应为是扇形交换机_路由键无需要配置_配置了也不生效）将三个队列都绑定到一个交换机上
     **/

    @Bean
    Binding fanBindingDirect() {
        return BindingBuilder.bind(fanSimpleModeQueue()).to(fanExchangeBindingSimpleMode());
    }

    /**
     * @return: org.springframework.amqp.core.Binding
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:就队列2绑定到扇形交换机
     **/
    @Bean
    Binding fanBindingDirect2() {
        return BindingBuilder.bind(fanSimpleModeQueue2()).to(fanExchangeBindingSimpleMode());
    }

    /**
     * @return: org.springframework.amqp.core.Binding
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:就队列3绑定到扇形交换机
     **/
    @Bean
    Binding fanBindingDirect3() {
        return BindingBuilder.bind(fanSimpleModeQueue3()).to(fanExchangeBindingSimpleMode());
    }

    /**
     * @return: org.springframework.amqp.core.DirectExchange
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:不绑定队列的交换机测试回调
     **/
    @Bean
    DirectExchange noQueueExchange() {
        return new DirectExchange(RabbitMqConstant.NO_QUEUE_TEST_EXCHANGE);
    }
}
