package com.xns.demo2;

/**
 * @Author: xns
 * @Date: 19-12-30 下午9:54
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println("任务1执行.....");
        int temp=0;
        for (int i = 0; i < 1000000000; i++) {
            temp+=i;
        }
//        new Thread(()->{
//            int temp=0;
//            for (int i = 0; i < 1000000000; i++) {
//                temp+=i;
//            }
//        }).start();
        System.out.println("任务2执行.....");
        System.out.println("任务3执行.....");
    }
}
