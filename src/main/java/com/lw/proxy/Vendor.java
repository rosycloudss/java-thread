package com.lw.proxy;

/**
 * 生产厂家
 */
public class Vendor implements Sell {
    @Override
    public void sell() {
        System.out.println("In sell method");
    }

    @Override
    public void ad() {
        System.out.println("ad method");
    }
}
