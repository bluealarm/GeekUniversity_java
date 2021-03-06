package com.jyz.threaddemo;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class SleepMethod {

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();
        int[] result = {0};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                result[0] = sum();
            }
        });
        thread.start();
        //最简单方法  主线程直接睡5秒
        Thread.sleep(5000);
        System.out.println("异步计算结果为："+result[0]);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}

