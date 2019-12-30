package com.xns.demo2;

/**
 * @Author: xns
 * @Date: 19-12-30 下午9:31
 */
class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"线程A").start();
        mt.run();
//        new Thread(mt).start();
//        new Thread(mt).start();
//        new Thread(mt).start();
//        new Thread(mt,"线程B").start();
    }
}
