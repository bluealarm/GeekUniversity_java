package com.jyz.threaddemo;

import java.util.concurrent.TimeUnit;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */

public class ManualSpinMethod {

    private int sum;

    private void setSum() {
        this.sum = fibo(36);
    }

    private int getSum() throws InterruptedException {
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ManualSpinMethod manualSpinMethod = new ManualSpinMethod();

        new Thread(manualSpinMethod::setSum).start();

        int result; //这是得到的返回值
        while ((result = manualSpinMethod.getSum()) == 0) {
            TimeUnit.MILLISECONDS.sleep(10);
        }
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}

