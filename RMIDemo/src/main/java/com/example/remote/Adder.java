package com.example.remote;

import java.rmi.Remote;

/**
 * Created by Administrator on 2017/8/26.
 * 远程接口
 */
public interface Adder extends Remote {
    public int add(int a, int b);
}
