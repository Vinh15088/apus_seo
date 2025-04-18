package org.example.thread.concurrent;

import java.util.concurrent.Semaphore;

public class ThreadSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        Runnable task = () -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting...");
                semaphore.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
                Thread.sleep(5000);
                System.out.println("Thread " + Thread.currentThread().getName() + " is finished.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        };

        for(int i=0; i<4; i++) {
            Thread thread = new Thread(task, "Thread " + i);
            thread.start();
        }
    }
}
