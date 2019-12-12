package com.design.singleton.ordinary;

/**
 * @Classname Singleton
 * @Description TODO
 * @Date 19-12-12 下午3:45
 * @Created by xns
 */
public class SingleObject {

    //创建SingleObject的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为private,这样该类就不会被实例化
    private SingleObject(){}

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World");
    }
}
