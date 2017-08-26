package com.example.remote;

import java.rmi.Naming;

/**
 * Created by Administrator on 2017/8/26.
 * 服务端类
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            Adder adder = new AdderRemote();
            Naming.bind("rmi://localhost:5000/adder", adder);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
