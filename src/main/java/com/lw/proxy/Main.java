package com.lw.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        //创建中介类实例
        DynamicProxy inter = new DynamicProxy(new Vendor());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //获取代理类实例sell
        //loader：定义了代理类的ClassLoder; interfaces：代理类实现的接口列表 h：调用处理器
        Sell sell = (Sell) (Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, inter));

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();


    }
}
