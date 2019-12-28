package com.xns.demo1;

/**
 * @Author: xns
 * @Date: 19-12-28 下午9:57
 */
public class EqualsTest {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
//        t.run();
        t.start();
        System.out.print("ping");
    }

    public static void pong() {
        System.out.print("pong");
    }
}
