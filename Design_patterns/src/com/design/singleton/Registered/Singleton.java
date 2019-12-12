package com.design.singleton.Registered;

/**
 * @Classname Singleton不太懂，有点瞌睡了
 * @Date 19-12-12 下午6:17
 * @Created by xns
 */
public class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
