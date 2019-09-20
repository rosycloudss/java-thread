package com.lw.proxy;

/**
 * 代理商
 */
public class BusinessAgent implements Sell {
    private Sell vendor;

    public BusinessAgent(Sell vendor) {
        this.vendor = vendor;
    }

    @Override
    public void sell() {
        System.out.println("我是代理商，我正在销售产品");
        vendor.sell();
        System.out.println("我是代理商，我正在销售产品");
    }

    @Override
    public void ad() {
        vendor.ad();
    }
}
