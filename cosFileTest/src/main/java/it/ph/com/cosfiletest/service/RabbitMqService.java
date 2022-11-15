package it.ph.com.cosfiletest.service;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：RabbitMQ接口层
 */
public interface RabbitMqService {
    /**
     * @param msg 消息
     * @param key 队列key
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消息发送给指定消费这消费
     **/
    void simpleMode(String msg, String key);

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消息发送给指定消费这消费(绑定交换机)
     **/
    void bindingSimpleMode(String msg, String key);

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:Topic绑定交换机
     **/
    void topicBindingSimpleMode(String msg, String key);

}
