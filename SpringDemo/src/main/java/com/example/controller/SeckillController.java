package com.example.controller;

import com.example.bean.SeckillGood;
import com.example.bean.SeckillOrder;
import com.example.service.SeckillGoodService;
import com.example.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by Administrator on 2017/8/27.
 * 秒杀控制器
 */
@Controller
@RequestMapping("/seckills")
public class SeckillController {
    @Autowired
    private SeckillOrderService seckillOrderService;
    @Autowired
    private SeckillGoodService seckillGoodService;
    private static final String  ORDERURL = "http://localhost:8080/seckills/";

    /**
     * 进行秒杀
     * @param seckillOrder
     * @return
     * @throws InterruptedException
     */
    @PostMapping("/")
    @ResponseBody
    @Transactional
    public String seckillGoods(SeckillOrder seckillOrder) throws InterruptedException {
        SeckillGood seckillGood = seckillGoodService.getSeckillGood(seckillOrder.getSeckillGoodId());
        if(seckillGood.getStoreCount() > 0) {
            //模拟网络延迟
            Thread.sleep(1000);
            int updateResult = seckillGoodService.updateSeckillGood(seckillOrder.getCount());
            if(updateResult > 0) {
                int addResult = seckillOrderService.addSeckillOrder(seckillOrder);
                if(addResult > 0) {
                    return "秒杀成功";
                }
            }
        }
        return "秒杀失败";
    }

    /**
     * 并发测试
     * @return
     */
    @GetMapping("/test")
    @ResponseBody
    public String testSeckill() {
        final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //开启50个线程
        for (int i = 0; i < 50; i++) {
            final int id = i + 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ClientHttpRequest request = null;
                    try{
                        StringBuffer str = new StringBuffer(ORDERURL);
                        str.append("?userId=" + id);
                        str.append("&count=1");
                        str.append("&seckillGoodId=1");
                        URI uri = new URI(str.toString());
                        request = factory.createRequest(uri, HttpMethod.POST);
                        InputStream inputStream = request.execute().getBody();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line = "";
//                        String result = "";
                        while ((line = reader.readLine()) != null) {
                            System.out.println("user : " + id + "-------" + line);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return "ok";
    }
}
