package com.xns.test;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 19-12-9 下午8:44
 * @Created by xns
 * 利用反射机制可以获取类对象(获取类对象之后我们ｂｉａｎ
 */
public class Demo {
    public static void main(String[] args)throws Exception{

        //字节码时执行
        //类型.class
        Class clz = User.class;
        System.out.println(clz);

        //创建对象时执行
        //对象名
        Class clz1 = new User().getClass();
        System.out.println(clz == clz1);

        //源码时候执行,常用,反射机制在框架中的应用,在框架中的用用可以通过配置文件写入所创建的类名，再利用第三种方法获取类对象
        //Class.forName()
        Class clz2 = Class.forName("com.xns.test.User");
        System.out.println(clz==clz2);
    }
}
