package org.example.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadStarvation {

    private static final ReentrantLock lock = new ReentrantLock(); // prevent starvation

    public static void main(String[] args) {
        Runnable longTask = () -> {
            while (true) {
                lock.lock();

                try {
                    System.out.println(Thread.currentThread().getName() + " is running long task.");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable shortTask = () -> {
            while (true) {
//                if(lock.tryLock()) {
//                    try {
//                        Thread.sleep(500);
//                        System.out.println(Thread.currentThread().getName() + " is running short task.");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    } finally {
//                        lock.unlock();
//                    }
//                } else {
//                    System.out.println(Thread.currentThread().getName() + " is unable to run short task.");
//                }

                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " is running short task.");
                } finally {
                    lock.unlock();
                }
            }
        };


        Thread thread1 = new Thread(longTask, "Thread 1");
        Thread thread2 = new Thread(longTask, "Thread 2");
        Thread starved = new Thread(shortTask, "Starved Thread");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        starved.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        starved.start();
    }
}
