package com.sg.mq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class InvokeAllTest {

    private static ExecutorService executor = new ThreadPoolExecutor(5, 10,
            1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
            new MyThreadFactory());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new InvokeAllThread());
        }
        System.out.println("第一次任务执行前的executor： " + executor);
        solve(executor, tasks, a -> {
            System.out.println("任务A执行结果:" + a);
        });
        //List<Future<Integer>> futures1 = executor.invokeAll(tasks);
        //System.out.println("结果总数：= "+futures1.size());
        System.out.println("第一次任务执行完毕后的executor： " + executor);
        System.out.println("==============第一次任务执行完毕，开始第二次任务============");
        try {
            Thread.sleep(1000);
            solve(executor, tasks, a -> {
                System.out.println("任务B执行结果:" + a);
            });
            //List<Future<Integer>> futures = executor.invokeAll(tasks);
            //System.out.println("结果总数：= "+futures.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第二次任务执行完毕后的executor：" + executor);
    }

    public static <T> List<T> solve(Executor e, Collection<Callable<T>> solvers, Consumer<T> use) throws InterruptedException, ExecutionException {
        List<T> result = new ArrayList<>();
        CompletionService<T> ecs = new ExecutorCompletionService<T>(e);
        for (Callable<T> s : solvers) {
            Future<T> submit = ecs.submit(s);
        }
        int n = solvers.size();
        for (int i = 0; i < n; ++i) {
            T r = ecs.take().get();
            if (r != null) {
                use.accept(r);
            }
            result.add(r);
        }
        System.out.println("结果总数：= "+result.size());
        return result;
    }

    // 任务执行线程。通过打印线程名称，观察提交的任务被哪个线程执行
    static class InvokeAllThread implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("线程开始执行：===="+Thread.currentThread().getName());
            //Integer i = 10/Integer.valueOf(Thread.currentThread().getName());
            try {
                Integer i = 10/Integer.valueOf(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("异常：= "+e);
                throw new Exception("异常：= "+e);
            }
            return Thread.currentThread().getPriority();
        }
    }

    // 给工作线程自定义名字，方便观察提交的任务被哪个线程执行
    static class MyThreadFactory implements ThreadFactory {
        private AtomicInteger threadNum = new AtomicInteger(0);
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