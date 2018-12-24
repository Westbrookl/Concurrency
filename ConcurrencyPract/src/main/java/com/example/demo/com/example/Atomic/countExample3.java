package com.example.demo.com.example.Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jhc on 2018/12/24
 * LongAdder
 */
public class countExample3 {
    public static int clientTotal = 5000;
    public static int threadTotal = 20;
    public static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
    }
    private static void add(){
        count.getAndIncrement();
    }
}
