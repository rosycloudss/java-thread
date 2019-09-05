package com.lw.proxy.cglib;

import com.lw.proxy.Vendor;

public class TestProxyFactoryCglib {
    public static void main(String[] args) {
        //目标对象
        Vendor vendor = new Vendor();
        System.out.println(vendor.getClass());
        //代理对象
        Vendor vendorProxy = (Vendor) new ProxyFactoryCglib(vendor).getProxyInstance();
        System.out.println(vendorProxy.getClass());
        //执行代理方法
        vendorProxy.sell();
    }
}
