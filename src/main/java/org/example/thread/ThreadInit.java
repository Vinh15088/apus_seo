package org.example.thread;

public class ThreadInit {

    static class MyThread extends Thread {
        private Thread thread;
        private String threadName;

        public MyThread(String name) {
            threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running with Thread: " + threadName);
        }

        public void start() {
            System.out.println("Starting " + threadName);
            if (thread == null) {
                thread = new Thread(this, threadName);
                thread.start();
            }
        }
    }

    static class MyRunnable implements Runnable {
        private Thread t;
        private String threadName;

        public MyRunnable(String name) {
            threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running with Runnable: " + threadName);
        }

        public void start() {
            System.out.println("Starting " + threadName);
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // init from class Thread
        MyThread thread1 = new MyThread("Thread 1");
        thread1.start();

        // init from interface Runnable
        MyRunnable runnable1 = new MyRunnable("Runnable 2");
        runnable1.start();

        System.out.println("Main Thread stopped");
    }
}
