package org.example.thread;

public class ThreadVolatile {
    private static boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (isRunning) {

            }

            System.out.println("Thread is running...");
        });

        thread.start();
        Thread.sleep(2000);

        isRunning = false;
    }
}
