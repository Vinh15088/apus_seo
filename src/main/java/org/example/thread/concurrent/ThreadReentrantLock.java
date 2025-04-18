package org.example.thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLock {
    private int count = 10;
    private final ReentrantLock lock = new ReentrantLock();

    public void decrement(int amount) throws InterruptedException {
        lock.lock(); // start synchronize

        try {
            Thread.sleep(500);
            if(count > amount) {
                System.out.println(Thread.currentThread().getName() + " is trying to decrement.");
                count -= amount;
                System.out.println(Thread.currentThread().getName() + " has decremented. Remaining count: " + count);
            } else {
                System.out.println(Thread.currentThread().getName() + " is unable to decrement.");
            }
        } finally { // make sure to return the lock
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadReentrantLock threadReentrantLock = new ThreadReentrantLock();

        Runnable task1 = () -> {
            for (int i=0; i<2; i++) {
                try {
                    Thread.sleep(500);
                    threadReentrantLock.decrement(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i=0; i<2; i++) {
                try {
                    Thread.sleep(500);
                    threadReentrantLock.decrement(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task2, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
