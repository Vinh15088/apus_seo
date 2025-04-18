package org.example.thread.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadReadWriteLock {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String message = "Hello World!";

    public static void main(String[] args) throws InterruptedException {
        Runnable read = () -> {
            if(lock.isWriteLocked()) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for write lock to be released.");
            }

            lock.readLock().lock();

            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is reading message: " + message);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.readLock().unlock();
            }
        };


        Runnable write1 = () -> {
            if(lock.isWriteLocked()) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for write lock to be released.");
            }

            lock.writeLock().lock();

            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is writing message: " + message);
                Long duration = (long) (Math.random() * 5000);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.writeLock().unlock();
            }
        };

        Runnable write2 = () -> {
            if(lock.isWriteLocked()) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for write lock to be released.");
            }

            lock.writeLock().lock();

            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is writing message: " + message);
                Long duration = (long) (Math.random() * 5000);
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.writeLock().unlock();
            }
        };

        Thread thread1 = new Thread(write1, "Thread 1");
        Thread thread2 = new Thread(write2, "Thread 2");
        Thread thread3 = new Thread(read, "Thread 3");
//        thread1.setPriority(3);
//        thread2.setPriority(2);
//        thread3.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }


}
