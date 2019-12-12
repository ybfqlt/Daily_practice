package com.design.singleton.Double_search;

/**
 * @Classname Singleton
 * @Description TODO
 * @Date 19-12-12 下午6:07
 * @Created by xns
 */
public class Singleton {
    /**
     * 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
     * 禁止进行指令重排序。（实现有序性）
     * volatile 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性。
     */
    /**
     * 保证当前结果的可见性
     */
    private volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
