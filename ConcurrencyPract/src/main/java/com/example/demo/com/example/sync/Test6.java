package com.example.demo.com.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jhc on 2018/12/24
 * 使用线程池的有点在于可以让两个线程同时开始
 * synchronized 修饰方法和修饰代码块
 */
public class Test6 {
    public void inc(){
        synchronized(this){
            for(int i=0;i<10;i++){
                System.out.println("i "+ i);
            }
        }
    }
    public synchronized void inc1(){
        for(int i=0;i<10;i++){
            System.out.println("i1"+i);
        }
    }

    public static void main(String[] args){
        Test6 t6 = new Test6();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->{
            t6.inc();
        });
        exec.execute(()->{
            t6.inc();
        });

        exec.execute(()->{
            t6.inc1();
        });
        exec.execute(()->{
            t6.inc1();
        });
//        exec.shutdown();
    }
}
