package org.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread thread1 = new Thread();
        thread1.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Min Priority: " + thread1.getPriority());

        Thread thread2 = new Thread();
        thread2.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Normal Priority: " + thread2.getPriority());

        Thread thread3 = new Thread();
        thread3.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Max Priority: " + thread3.getPriority());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Void> task1 = () -> {
            Thread thread = Thread.currentThread();
            thread.setPriority(Thread.MIN_PRIORITY);
            System.out.println("Thread name: " + thread.getName());
            System.out.println("Thread priority: " + thread.getPriority());
            return null;
        };

        Callable<Void> task2 = () -> {
            Thread thread = Thread.currentThread();
            thread.setPriority(Thread.NORM_PRIORITY);
            System.out.println("Thread name: " + thread.getName());
            System.out.println("Thread priority: " + thread.getPriority());
            return null;
        };

        Callable<Void> task3 = () -> {
            Thread thread = Thread.currentThread();
            thread.setPriority(Thread.MAX_PRIORITY);
            System.out.println("Thread name: " + thread.getName());
            System.out.println("Thread priority: " + thread.getPriority());
            return null;
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();
    }
}
