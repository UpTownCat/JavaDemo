package com.example.service;

import com.example.bean.SeckillOrder;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface SeckillOrderService {
    /**
     * 添加秒杀订单
     * @param seckillOrder
     * @return
     */
    int addSeckillOrder(SeckillOrder seckillOrder);
}
