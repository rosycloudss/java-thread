package com.lw.proxy;

public class TestStaticProxy {
    public static void main(String[] args) {
        //目标对象
        Vendor vendor = new Vendor();
        //代理对象
        Sell sell = new BusinessAgent(vendor);
        sell.sell();
    }
}
