package com.design.singleton.Lazy_nosafe;

/**
 * @Classname Singleton
 * @Description 懒汉式，线程不安全
 * @Date 19-12-12 下午5:47
 * @Created by xns
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
