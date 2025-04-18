package org.example.thread;

public class ThreadLocalExample {

//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "default");

    public static void main(String[] args) {

        Runnable task1 = () -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("ThreadLocalExample 1 value: " + threadLocal.get());
            threadLocal.remove();
        };

        Runnable task2 = () -> {
            threadLocal.set(Thread.currentThread().getName());
            threadLocal.remove();
            System.out.println("ThreadLocalExample 2 value: " + threadLocal.get());
        };

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task2, "Thread 2");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
