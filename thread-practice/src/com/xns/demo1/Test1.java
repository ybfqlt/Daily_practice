package com.xns.demo1;

/**
 * @Author: xns
 * @Date: 19-12-28 下午9:28
 */
class MyThread extends Thread {

    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "运行, x = " + i);
        }
    }
}


public class Test1 {
    public static void main(String[] args) {
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}
