package com.xns.test;

import java.lang.reflect.Method;

/**
 * @Classname Demo3
 * @Description TODO
 * @Date 19-12-9 下午9:30
 * @Created by xns
 */
public class Demo3 {

    public static void main(String[] args) throws Exception {
        User u = new User("小巴",18);
        User u2 = new User("老赵",20);

        Class clz = Class.forName("com.xns.test.User");

        Method em = clz.getMethod("exit");

        /**
         * invoke（调用）就是调用Method类代表的方法。可以实现动态调用，例如可以动态的传人参数，可以把方法参数化
         * method.invoke(owner,args):执行该Method.invoke方法的参数只执行这个方法的对象owner,和参数数组args,可以理解:owner对象中带有参数args的method方法。返回值是Object,也既是该方法的返回值
         */
        /**
         * 调用获取到的方法，使用invoke关键字,此处表示调用有参方法
         */
        Object obj = em.invoke(u2);

        System.out.println(obj);

        Method lm = clz.getMethod("login",String.class,String.class);

        Object obj1 = lm.invoke(u2,"老赵","aixiaoba");

        /**
         * 方法名参考实体类User.java，因为方法为void类型，所以运行结果中会出现null，表示返回值为空。
         */
        System.out.println(obj1);
    }
}
