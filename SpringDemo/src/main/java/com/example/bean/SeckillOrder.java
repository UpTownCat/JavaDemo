package com.example.bean;

/**
 * Created by Administrator on 2017/8/27.
 */
public class SeckillOrder {
    private Integer id;
    private Integer seckillGoodId;
    private Integer userId;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeckillGoodId() {
        return seckillGoodId;
    }

    public void setSeckillGoodId(Integer seckillGoodId) {
        this.seckillGoodId = seckillGoodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
