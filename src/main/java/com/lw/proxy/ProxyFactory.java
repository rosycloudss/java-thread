package com.lw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object obj;//维护一个目标对象

    public ProxyFactory(Object obj) {
        this.obj = obj;
    }

    /**
     * 为目标对象生成代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before");
                //执行目标对象方法
                Object result = method.invoke(obj, args);
                System.out.println("After");
                return result;
            }
        });
    }
}
