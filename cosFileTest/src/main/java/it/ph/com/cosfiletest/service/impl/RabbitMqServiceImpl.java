package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.constant.RabbitMqConstant;
import it.ph.com.cosfiletest.producer.RabbitMqProducer;
import it.ph.com.cosfiletest.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PH
 * @时间： 2022/11/15
 * @描述：RabbitMq业务层
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {
    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @Override
    public void simpleMode(String msg, String key) {
        rabbitMqProducer.simpleMode(msg, "queue_simple_Mode");
    }

    @Override
    public void bindingSimpleMode(String msg, String key) {
        rabbitMqProducer.bindingSimpleMode(msg, RabbitMqConstant.KEY_BINDING_SIMPLE_MODE);
    }

    @Override
    public void topicBindingSimpleMode(String msg, String key) {
        rabbitMqProducer.topicBindingSimpleMode(msg, key);
    }

}
