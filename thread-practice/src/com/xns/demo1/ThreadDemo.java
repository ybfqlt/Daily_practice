package com.xns.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: xns
 * @Date: 19-12-29 下午1:23
 */
class MyThread3 implements Callable <String>{

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("**********线程执行、i = "+i);
        }
        return "线程执行完毕";
    }
}

/**
 * @Author: xns
 * @Date: 19-12-29 下午1:23
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyThread3());
        new Thread(task).start();
        System.out.println("[线程返回数据]" + task.get());
    }
}
