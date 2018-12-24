//package com.example.demo.count;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Semaphore;
//
///**
// * @author jhc on 2018/12/24
// */
//public class Count {
//    public static int clientTotal = 5000;
//    public static int threadTotal = 20;
//    public static int count = 0;
//    public static void main(String[] args) throws Exception{
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        final Semaphore semaphore = new Semaphore(threadTotal);
//        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
//        for(int i=0;i<clientTotal;i++){
//            executorService1.execute(()->{
//                try{
//                    semaphore.acquire();
//                    add();
//                    semaphore.release();
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        executorService1.shutdown();
//        System.out.println(count);
//    }
//    private static void add(){
//        count++;
//    }
//}
