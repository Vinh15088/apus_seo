package org.example.thread.concurrent;

import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads are finished.");
        });

        Runnable task = () -> {
            try {
                Thread.sleep((long) (Math.random() * 5000));
                System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
                cyclicBarrier.await();
                System.out.println("Thread " + Thread.currentThread().getName() + " continues...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for(int i=0; i<3; i++) {
            new Thread(task, "Thread " + i).start();
        }
    }
}
