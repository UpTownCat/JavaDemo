package com.example.test;

import com.example.util.MQUtil;
import org.apache.activemq.transport.SecureSocketConnectorFactory;
import org.apache.activemq.transport.mqtt.MQTTCodec;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by Administrator on 2017/8/26.
 * 事务测试
 */
public class TransactionTest {
    /**
     * 发送消息
     */
    @Test
    public void testTransactionSendMessage() throws JMSException {
        Connection connection = MQUtil.getDefaultConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("topic_transaction");
        MessageProducer producer = session.createProducer(topic);
        connection.start();
        TextMessage tm1 = session.createTextMessage();
        TextMessage tm2 = session.createTextMessage();
        TextMessage tm3 = session.createTextMessage();
        tm1.setText("transaction message 1");
//        throw new JMSException("test");
//        int i = 1 / 0;
        tm2.setText("transaction message 2");
//        tm3.setText("transaction message 3");
        producer.send(tm1);
        producer.send(tm2);
//        producer.send(tm3);
        session.commit();
        session.close();
        connection.close();
    }

    /**
     * 接收消息
     */
    @Test
    public void testTransactionReciveMessage() throws JMSException {
        Connection connection = MQUtil.getDefaultConnection();
        connection.setClientID("transaction_sub");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("topic_transaction");
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "sub");
        connection.start();
        Message message = subscriber.receive();
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("recieve the message is: " + textMessage.getText());
        }else {
            System.out.println("recieve other message");
        }
    }
}
