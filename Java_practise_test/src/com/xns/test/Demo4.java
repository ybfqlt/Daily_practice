package com.xns.test;

import java.lang.reflect.Method;

/**
 * @Classname Demo4
 * @Description TODO
 * @Date 19-12-9 下午10:02
 * @Created by xns
 */
public class Demo4 {
    public static void main(String[] args) throws Exception{
        User u = new User("小吧",18);
        User u2 = new User("老赵",20);

        Class clz = Class.forName("com.xns.test.User");

        /**
         * 获取私有方法名,又名暴力获取,此方法无视方法的访问权限,及时是被private修饰的方法也会被获取到
         */
        Method dm = clz.getDeclaredMethod("CheckInfo");

        /**
         * 获取调用该方法的权限
         */
        dm.setAccessible(true);

        Object obj = dm.invoke(u2);

        System.out.println(obj);
    }
}
