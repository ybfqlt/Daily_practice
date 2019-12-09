package com.xns.test;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @Classname Demo5
 * @Description TODO
 * @Date 19-12-9 下午10:08
 * @Created by xns
 */
public class Demo5 {
    public static void main(String[] args) throws Exception{
        Class clz = Class.forName("com.xns.test.User");

        Object obj = clz.newInstance();

        Field nf = clz.getField("name");

        nf.set(obj,"小巴");
        Object object = nf.get(obj);

        System.out.println(object);
    }
}
