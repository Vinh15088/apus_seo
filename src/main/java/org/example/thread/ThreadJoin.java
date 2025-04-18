package org.example.thread;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread("Thread 1") {
            @Override
            public void run() {
                System.out.println("Thread 1 started");
                try {
                    Thread.sleep(500);
                    System.out.println("Thread 1 sleeping...");
                    Thread.sleep(500);
                    System.out.println("Thread 1 sleeping...");
                    Thread.sleep(500);
                    System.out.println("Thread 1 sleeping...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 finished");
            }
        };
        thread1.start();

        Thread thread2 = new Thread("Thread 2") {
            @Override
            public void run() {
                System.out.println("Thread 2 started");
                try {
                    thread1.join(); // wait for thread1 to finish before starting thread2
                    Thread.sleep(500);
                    System.out.println("Thread 2 sleeping...");
                    Thread.sleep(500);
                    System.out.println("Thread 2 sleeping...");
                    Thread.sleep(500);
                    System.out.println("Thread 2 sleeping...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 finished");
            }
        };
        thread2.start();

        System.out.println("Main thread finished");
    }
}
