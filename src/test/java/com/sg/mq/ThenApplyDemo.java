package com.sg.mq;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ThenApplyDemo {

    private static int i=0;

    /**
     * 赛跑
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        /*测试 applyToEither*/
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("1号进来了");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1号结束");
            return 1;
        });
        cf1.applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("2号进来了");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2号结束");
            i=5;
            return 2;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("线程3进来了");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3号结束");
            return 3;
        }), a -> {
            return a;
        }), r -> {
            return r;
        }).join();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("i=="+i);

    }

}
