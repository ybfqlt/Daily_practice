package com.design.singleton.Hungry;

/**
 * @Classname Singleton
 * @Description 饿汉式,类加载时就初始化，浪费内存
 * @Date 19-12-12 下午6:04
 * @Created by xns
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
