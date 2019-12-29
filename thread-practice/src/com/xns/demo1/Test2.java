package com.xns.demo1;

/**
 * @Author: xns
 * @Date: 19-12-29 上午10:25
 */
class MyThread2 implements Runnable{
    private String title;

    public MyThread2(String title){
        this.title=title;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "运行, x = " + i);
        }
    }
}

public class Test2{
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread2("线程A"));
        Thread thread1 = new Thread(new MyThread2("线程B"));
        Thread thread2 = new Thread(new MyThread2("线程C"));
        thread.start();
        thread1.start();
        thread2.start();




//        for (int i = 0; i < 3; i++) {
//            String title = "线程对象-"+i;
//            Runnable run = ()->{
//                for (int j = 0; j < 10; j++) {
//                    System.out.println(title+"运行,j="+j);
//                }
//            };
//            new Thread(run).start();
//        }
//


//        for (int i = 0; i < 3; i++) {
//            String title = "线程对象-"+i;
//            new Thread(()->{
//                for (int j = 0; j < 10; j++) {
//                    System.out.println(title+"运行,j="+j);
//                }
//            }).start();
//        }



//        new Thread(new MyThread2("线程A")).start();
//        new Thread(new MyThread2("线程B")).start();
//        new Thread(new MyThread2("线程C")).start();
    }
}


