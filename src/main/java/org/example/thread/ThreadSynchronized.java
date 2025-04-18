package org.example.thread;

public class ThreadSynchronized {

    private int count = 10;

    public synchronized void decrement(int amount) {
        if(count > amount) {
            System.out.println(Thread.currentThread().getName() + " is trying to decrement.");
            count -= amount;
            System.out.println(Thread.currentThread().getName() + " has decremented. Remaining count: " + count);
        } else {
            System.out.println(Thread.currentThread().getName() + " is unable to decrement.");
        }
    }

    public static void main(String[] args) {
        ThreadSynchronized threadSynchronized = new ThreadSynchronized();

        Runnable task1 = () -> {
            for (int i=0; i<2; i++) {
                try {
                    Thread.sleep(500);
                    threadSynchronized.decrement(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i=0; i<2; i++) {
                try {
                    Thread.sleep(500);
                    threadSynchronized.decrement(5);
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
