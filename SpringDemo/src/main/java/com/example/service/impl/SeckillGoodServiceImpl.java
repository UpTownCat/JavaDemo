package com.example.service.impl;

import com.example.bean.SeckillGood;
import com.example.dao.SeckillGoodDao;
import com.example.service.SeckillGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/27.
 */
@Service
public class SeckillGoodServiceImpl implements SeckillGoodService {
    @Autowired
    private SeckillGoodDao seckillGoodDao;

    /**
     * 更新秒杀商品的数量
     * @param count
     * @return
     */
    @Override
    public int updateSeckillGood(int count) {
        return seckillGoodDao.updateSeckillGood(count);
    }

    /**
     * 通过id获取秒杀商品
     * @param id
     * @return
     */
    @Override
    public SeckillGood getSeckillGood(int id) {
        return seckillGoodDao.selectSeckillGoodById(id);
    }
}
