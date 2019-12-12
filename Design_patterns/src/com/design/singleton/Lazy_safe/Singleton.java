package com.design.singleton.Lazy_safe;

/**
 * @Classname Singleton
 * @Description 懒汉式，线程安全
 * @Date 19-12-12 下午5:56
 * @Created by xns
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
