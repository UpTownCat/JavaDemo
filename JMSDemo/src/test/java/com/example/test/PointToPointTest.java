package com.example.test;

import com.example.util.MQUtil;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by Administrator on 2017/8/26.
 * 点对点测试
 */
public class PointToPointTest {
    /**
     * 发送消息测试
     * @throws JMSException
     */
    @Test
    public void testSendMessage() throws JMSException {
        String message = "hello, uptowncat";
        Connection connection = MQUtil.getDefaultConnection();
        //获取回话，第一个参数表示是否开启事务，第二个参数表示通知的类型
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("queue");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText(message);
        //打开连接
        connection.start();
        producer.send(textMessage);
        session.close();
        connection.close();
    }

    /**
     * 接收消息
     * @throws JMSException
     */
    @Test
    public void testRecieveMessage() throws JMSException {
        Connection connection = MQUtil.getDefaultConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("queue");
        MessageConsumer consumer = session.createConsumer(queue);
        connection.start();
        Message message = consumer.receive();
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("recieve the message is: " + textMessage.getText());
        }else {
            System.out.println("recieve other message");
        }
        session.close();
        connection.close();
    }

}
