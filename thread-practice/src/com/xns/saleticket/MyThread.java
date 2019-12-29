package com.xns.saleticket;

/**
 * @Author: xns
 * @Date: 19-12-29 下午12:17
 */
public class MyThread implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (this.ticket > 0) {
                System.out.println("卖票:ticket= " + this.ticket--);
            }
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();


//        new MyThread().start();
//        new MyThread().start();
//        new MyThread().start();
    }
}

