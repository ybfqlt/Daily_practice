package com.xns.test;

/**
 * @Classname Demo2
 * @Description TODO
 * @Date 19-12-9 下午9:23
 * @Created by xns
 */
public class Demo2 {

    public static void main(String[] args) throws Exception{
        Class clz = Class.forName("com.xns.test.User");
        System.out.println(clz);

        Object obj = clz.newInstance();
        System.out.println(obj);
    }
}
