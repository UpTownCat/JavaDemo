package com.example.service;

import com.example.bean.SeckillGood;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface SeckillGoodService {
    /**
     * 更新秒杀商品的数量
     * @param count
     * @return
     */
    int updateSeckillGood(int count);

    /**
     * 通过id获取秒杀商品
     * @param id
     * @return
     */
    SeckillGood getSeckillGood(int id);
}
