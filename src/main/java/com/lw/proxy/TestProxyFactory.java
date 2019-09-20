package com.lw.proxy;

public class TestProxyFactory {
    public static void main(String[] args) {
        Sell vendor = new Vendor();
        System.out.println(vendor.getClass());//输出目标对象信息
        Sell sell = (Sell) new ProxyFactory(vendor).getProxyInstance();
        System.out.println(sell.getClass());//输出代理对象信息
        sell.sell();
    }
}
