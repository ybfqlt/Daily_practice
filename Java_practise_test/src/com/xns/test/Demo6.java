package com.xns.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Classname Demo6
 * @Description TODO
 * @Date 19-12-9 下午10:13
 * @Created by xns
 */
public class Demo6 {
    public static void main(String[] args) throws Exception{
        User u = new User("小巴",18);

        Class clz = Class.forName("com.xns.test.User");

        Field af = clz.getDeclaredField("age");

        af.setAccessible(true);

        Object obj = af.get(u);

        System.out.println(obj);
    }
}
