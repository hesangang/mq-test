package com.sg.mq;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureTest {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
            1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
            new MyThreadFactory());

    public static void main(String[] args) throws Exception {
        //whenComplete();
        handle();
    }

    public static void handle() throws Exception{
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {

            @SneakyThrows
            @Override
            public Integer get() {
                int i= 10/0;
                return new Random().nextInt(10);
            }
        },executor);
        /*future.handle(new BiFunction<Integer, Throwable, Integer>() {
            @SneakyThrows
            @Override
            public Integer apply(Integer param, Throwable throwable) {
                int result = -1;
                TimeUnit.SECONDS.sleep(3);
                if(throwable==null){
                    result = param * 2;
                    System.out.println("处理执行结果："+param);
                }else{
                    System.out.println("处理执行结果："+throwable.getMessage());
                }
                return result;
            }
        });*/
        future.whenComplete(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer integer, Throwable t) {

                System.out.println("执行完成！"+t);
            }
        });
        future.exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable t) {
                System.out.println("执行失败！"+t.getMessage());
                return 0;
            }
        });

        //System.out.println("=="+future.get());
    }


    public static void whenComplete() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if(new Random().nextInt()%2>=0) {
                int i = 12/1;
            }
            System.out.println("run end ...");
        });

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("执行完成！");
            }

        });
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("执行失败！"+t.getMessage());
                return null;
            }
        });

        TimeUnit.SECONDS.sleep(2);
    }

    private static void thenApply() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1="+result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t*5;
                System.out.println("result2="+result);
                return result;
            }
        });

        long result = future.get();
        System.out.println(result);
    }


    // 任务执行线程。通过打印线程名称，观察提交的任务被哪个线程执行
    static class InvokeAllThread implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("线程开始执行：===="+Thread.currentThread().getName());
            return Thread.currentThread().getPriority();
        }
    }

    // 给工作线程自定义名字，方便观察提交的任务被哪个线程执行
    static class MyThreadFactory implements ThreadFactory {
        private AtomicInteger threadNum = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, String.valueOf(threadNum.getAndIncrement()));
            if (thread.getPriority() != Thread.NORM_PRIORITY) {
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;
        }
    }
}
