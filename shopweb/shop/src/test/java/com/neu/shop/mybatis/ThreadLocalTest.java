package com.neu.shop.mybatis;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author mss
 * @Date 2020/10/8 16:41
 * @Version 1.0
 */
public class ThreadLocalTest{
    public static void main(String[] args) throws Exception{
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName() + ".");

        MyThread1 thread1 = new MyThread1();
        thread1.setName("线程一");
        thread1.start();

        Thread thread2 = new Thread(new MyThread2());
        thread2.setName("线程二");
        thread2.start();

        FutureTask task = new FutureTask<String>(new MyThread3());
        Thread thread3 = new Thread(task);
        thread3.setName("线程三");
        thread3.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始运行");
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始运行");
    }
}

class MyThread3 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "开始运行");
        return Thread.currentThread().getName() + "开始运行";
    }
}