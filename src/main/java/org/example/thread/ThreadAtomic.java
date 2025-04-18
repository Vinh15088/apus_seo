package org.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomic {
    private static final AtomicInteger count1 = new AtomicInteger(0);
    private static int count2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            for (int i=0; i<10; i++) {
                count1.incrementAndGet();
            }
        };

        Runnable task2 = () -> {
            for (int i=0; i<10; i++) {
                count2++;

                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task1, "Thread 2");
        Thread thread3 = new Thread(task2, "Thread 3");
        Thread thread4 = new Thread(task2, "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Final count 1: " + count1.get());
        System.out.println("Final count 2: " + count2);
    }
}
