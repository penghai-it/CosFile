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
    void simpleMode(String msg);

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:单列模式消息发送给指定消费这消费(绑定交换机)
     **/
    void bindingSimpleMode(String msg);

    /**
     * @param msg 消息
     * @param key 队列key
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:Topic绑定交换机
     **/
    void topicBindingSimpleMode(String msg, String key);

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:扇形交换机
     **/
    void fanBindingSimpleMode(String msg);

    /**
     * @param msg 消息
     * @return:
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:消息推送到server_但是在server里找不到交换机(交换机不存在测试回调)
     **/
    void noExchangeTest(String msg);

    /**
     * @param msg 消息
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:消息推送到server_找到交换机了_但是没找到队列(交换机没有绑定队列)
     **/
    void noQueueExchange(String msg);
}
