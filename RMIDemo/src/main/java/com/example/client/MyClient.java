package com.example.client;

import com.example.remote.Adder;

import java.rmi.Naming;

/**
 * Created by Administrator on 2017/8/26.
 * 客户端类
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Adder adder = (Adder) Naming.lookup("rmi://localhost:5000/adder");
            System.out.println(adder.add(45, 55));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
