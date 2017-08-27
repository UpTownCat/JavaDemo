package com.example.service.impl;

import com.example.bean.SeckillOrder;
import com.example.dao.SeckillOrderDao;
import com.example.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/27.
 */
@Service
public class SeckillOrderServiceImpl implements SeckillOrderService{
    @Autowired
    private SeckillOrderDao seckillOrderDao;

    public SeckillOrderServiceImpl() {
        //清空所有秒杀订单
//        seckillOrderDao.deleteAll();
    }

    /**
     * 添加秒杀订单
     * @param seckillOrder
     * @return
     */
    @Override
    public int addSeckillOrder(SeckillOrder seckillOrder) {
        return seckillOrderDao.insertSeckillOrder(seckillOrder);
    }
}
