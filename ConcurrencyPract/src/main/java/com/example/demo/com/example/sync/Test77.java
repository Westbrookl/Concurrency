package com.example.demo.com.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jhc on 2018/12/24
 */
public class Test77 {
    public synchronized static void inc1() {
        for (int i = 0; i < 10; i++) {
            System.out.print("i1   " + i+" ");
        }
    }

    public static void inc() {
        synchronized (Test77.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print("i   " + i+" ");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
//        Test77 t7 = new Test77();
        exec.execute(() -> {
            inc();
        });
        exec.execute(() -> {
            inc();
        });
//        System.out.println("--------------");
        exec.execute(() -> {
            inc1();
        });        exec.execute(() -> {
            inc1();
        });

    }
}
