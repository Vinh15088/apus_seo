package org.example.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(3);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                Thread.sleep(500);
                COUNT_DOWN_LATCH.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 finished");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            try {
                Thread.sleep(500);
                COUNT_DOWN_LATCH.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 finished");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 3 started");
            try {
                Thread.sleep(500);
                COUNT_DOWN_LATCH.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 3 finished");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            COUNT_DOWN_LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads finished");
    }
}
