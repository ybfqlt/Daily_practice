package com.xns.demo1;

/**
 * @Author: xns
 * @Date: 19-12-29 上午11:21
 */
public class Test4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run of Runnable");
            }
        }){
            @Override
            public void run(){
                System.out.println("Run of Thread");
                super.run();
            }
        }.start();
    }
}
