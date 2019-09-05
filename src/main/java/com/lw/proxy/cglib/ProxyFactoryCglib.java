package com.lw.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactoryCglib implements MethodInterceptor {
    private Object obj; //维护一个目标对象

    public ProxyFactoryCglib(Object obj) {
        this.obj = obj;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(obj.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before");
        //执行目标对象的方法
        Object result = method.invoke(obj, objects);
        System.out.println("after");
        return result;
    }
}
