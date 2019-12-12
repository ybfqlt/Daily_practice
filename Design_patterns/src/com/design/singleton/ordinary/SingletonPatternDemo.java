package com.design.singleton.ordinary;

import com.design.singleton.ordinary.SingleObject;

/**
 * @Classname SingletonPatternDemo
 * @Description TODO
 * @Date 19-12-12 下午3:49
 * @Created by xns
 */
public class SingletonPatternDemo {
    public static void main(String[] args){

        /**
         * 编译时错误，构造函数SingleObject()是不可见的;
         */
        //SingleObject object1 = new SingleObject();

        SingleObject object = SingleObject.getInstance();

        //显示消息
        object.showMessage();
    }
}
