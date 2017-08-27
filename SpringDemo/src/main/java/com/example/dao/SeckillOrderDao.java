package com.example.dao;

import com.example.bean.SeckillOrder;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface SeckillOrderDao {
    /**
     * 清除所有秒杀但
     * @return
     */
    int deleteAll();

    /**
     * 添加秒杀单
     * @param seckillOrder
     * @return
     */
    int insertSeckillOrder(SeckillOrder seckillOrder);
}
