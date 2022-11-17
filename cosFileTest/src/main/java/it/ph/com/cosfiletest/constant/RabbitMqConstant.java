package it.ph.com.cosfiletest.constant;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：MQ常量类
 */
public class RabbitMqConstant {
    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:队列（单例交换机）
     **/

    public static final String QUEUE_BINDING_SIMPLE_MODE = "queue_binding_simple_mode";
    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:队列的key（单例交换机）
     **/
    public static final String KEY_BINDING_SIMPLE_MODE = "key_binding_simple_mode";

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:交换机（单例交换机）
     **/
    public static final String EXCHANGE_BINDING_SIMPLE_MODE = "exchange_binding_simple_mode";


    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:队列（Topic交换机）
     **/
    public static final String TOPIC_BINDING_SIMPLE_MODE_QUEUE = "topic.binding_simple_mode_queue";
    public static final String TOPIC_BINDING_SIMPLE_MODE_QUEUE2 = "topic.binding_simple_mode_queue2";

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:交换机（Topic交换机）
     **/
    public static final String TOPIC_BINDING_SIMPLE_MODE_EXCHANGE = "topic_binding_simple_mode_exchange";

    /**
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:扇型交换机队列
     **/
    public static final String FAN_BINDING_SIMPLE_MODE_QUEUE = "fan_binding_simple_mode_queue";
    public static final String FAN_BINDING_SIMPLE_MODE_QUEUE2 = "fan_binding_simple_mode_queue2";
    public static final String FAN_BINDING_SIMPLE_MODE_QUEUE3 = "fan_binding_simple_mode_queue3";

    /**
     * @创建者: PH
     * @时间: 2022/11/15
     * @描述:交换机（扇形交换机）
     **/
    public static final String FAN_BINDING_SIMPLE_MODE_EXCHANGE = "fan_binding_simple_mode_exchange";

    /**
     * @创建者: PH
     * @时间: 2022/11/17
     * @描述:不绑定队列的交换机名
     **/
    public static final String NO_QUEUE_TEST_EXCHANGE = "no_queue_test_exchange";
}
