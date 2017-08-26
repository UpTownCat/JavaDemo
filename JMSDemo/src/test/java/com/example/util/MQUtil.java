package com.example.util;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * Created by Administrator on 2017/8/26.
 */
public class MQUtil {
    private MQUtil(){}

    /**
     * 获取连接
     * @return
     * @throws JMSException
     */
    public static final Connection getDefaultConnection() throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        return factory.createConnection();
    }
}
