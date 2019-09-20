package com.lw.concurrency.chapter1;

/**
 * @ClassName:TemplateMethod
 * @Author:liwei
 * @Description: TODO 
 * @Date:2019/6/2 17:02
 * @Version: V1.0
 *
 */
public class TemplateMethod {

    public final void print(String message){
        System.out.println("#####################");
        wrapPrint(message);
        System.out.println("#####################");
    }

    protected void wrapPrint(String message){
        
    }
}
