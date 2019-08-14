package com.lw.java.thread.core.chapter3.inheritableThreadLocal;

import java.util.Date;

public class InheritableThreadLocalTxt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    /**
     * 当在父线程中取值后调用此方法，子线程取出的值就是修改后的值
     *
     * @param parentValue
     * @return
     */
    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " 我在子线程加的~！";
    }
}
