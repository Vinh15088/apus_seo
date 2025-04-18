package org.example.thread;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {

                System.out.println("Thread is running...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted during sleep.");

                    Thread.currentThread().interrupt();
//                    System.out.println("After sleep interrupted: " + Thread.currentThread().isInterrupted());
//                    System.out.println("Thread.interrupted: " + Thread.interrupted());
                    break;
                }
            }

            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted. Exiting loop.");
            }
        });

        thread.start();

        Thread.sleep(2500);

        thread.interrupt();
    }
}
