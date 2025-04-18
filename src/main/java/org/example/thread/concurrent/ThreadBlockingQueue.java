package org.example.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    System.out.println("Producer trying to produce: " + queue.offer(i));
                    System.out.println("Producer trying to produce: ");
                    queue.put(i);
                    System.out.println("Producer produced: " + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Consumer trying to consume: " + queue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
