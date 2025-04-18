package org.example.thread;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State after creation: " + thread.getState());

        thread.start();
        System.out.println("State after start: " + thread.getState());

        Thread.sleep(100);
        System.out.println("State after sleep: " + thread.getState());

//        thread.interrupt();
//        System.out.println("State after interrupt: " + thread.getState());

        thread.join();
        System.out.println("State after join: " + thread.getState());
    }
}
