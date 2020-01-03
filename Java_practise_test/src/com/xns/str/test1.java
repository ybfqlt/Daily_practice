package com.xns.str;

/**
 * @Author: xns
 * @Date: 20-1-3 下午6:54
 */
public class test1 {
    public static void main(String[] args) {
        String x = new String("张三");
        fun(x);
        System.out.println(x);
    }

    public static void fun(String x){
        x = "李四";
    }
}
