package com.example.dao;

import com.example.bean.SeckillGood;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface SeckillGoodDao {
    /**
     * 条件秒杀商品
     * @param seckillGood
     * @return
     */
//    int insertSeckillGood(SeckillGood seckillGood);

    /**
     * 秒杀更新商品数量
     * @param count
     * @return
     */
    int updateSeckillGood(int count);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    SeckillGood selectSeckillGoodById(int id);
}
