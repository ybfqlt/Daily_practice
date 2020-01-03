package com.xns.str;

/**
 * @Author: xns
 * @Date: 20-1-3 下午6:58
 */
public class test2 {
    public static void main(String[] args) {
        StringBuilder x = new StringBuilder("张安");
        change(x);
        System.out.println(x);
    }

    public static void change(StringBuilder x){
//        x = new StringBuilder("张三");
        x.delete(1,2).append("三");
    }
}
