package it.ph.com.cosfiletest.monitor;

import com.rabbitmq.client.Channel;
import it.ph.com.cosfiletest.utils.TypeConversionUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @author PH
 * @时间： 2022/11/17
 * @描述： 手动确认消息监听类
 */
@Component
public class RabbitMqReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            byte[] body = message.getBody();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(body));
            Map<String, String> msgMap = TypeConversionUtils.objectTurnMap(ois.readObject());
            ois.close();
            System.out.println("  MyAckReceiver  messageId:" + msgMap.get("messageId") + "  messageData:" + msgMap.get("messageData") + "  createTime:" + msgMap.get("createTime"));
            System.out.println("消费的主题消息来自：" + message.getMessageProperties().getConsumerQueue());
            //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            //第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            e.printStackTrace();
        }
    }
}
