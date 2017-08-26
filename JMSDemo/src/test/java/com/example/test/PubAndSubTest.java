package com.example.test;

import com.example.util.MQUtil;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by Administrator on 2017/8/26.
 * 发送和订阅测试
 */
public class PubAndSubTest {
    /**
     * 推送测试
     * @throws JMSException
     */
    @Test
    public void testPublishMessage() throws JMSException {
        Connection connection = MQUtil.getDefaultConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("topic");
        TextMessage textMessage = session.createTextMessage();
        MessageProducer producer = session.createProducer(topic);
        textMessage.setText("this is the pub-sub test33");
        connection.start();
        producer.send(textMessage);
        System.out.println("send message success");
        session.close();
        connection.close();
    }

    /**
     * 订阅测试
     * @throws JMSException
     */
    @Test
    public void testSubscribeMessage() throws JMSException {
        Connection connection = MQUtil.getDefaultConnection();
        connection.setClientID("subscriber_5");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("topic");
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "subscriber_5");
        connection.start();
//        subscriber.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                if(message instanceof TextMessage) {
//                    TextMessage textMessage = (TextMessage) message;
//                    try {
//                        System.out.println("recieve message : " + textMessage.getText());
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                }else {
//                    System.out.println("reiceve other message");
//                }
//            }
//        });
        Message message = subscriber.receive();
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("recieve message is: " + textMessage.getText());
        }else {
            System.out.println("recieve other messge");
        }
    }
}
