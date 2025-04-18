package org.example.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVirtual {

    public void createVirtualThread() throws InterruptedException {

        Thread.startVirtualThread(() -> {
            System.out.println("Create Virtual Thread with startVirtualThread");
        });

        Thread.ofVirtual().start(() -> {
            System.out.println("Create Virtual Thread with ofVirtual");
        });

    }

    public void usingExecutorService() throws ExecutionException, InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Create Virtual Thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

        for (int i=0; i<5; i++) {
            service.submit(task);
        }

        service.close();
    }

    public void testPerformance() {
        Random random = new Random();
        Runnable runnable = () -> {
            double i = random.nextDouble(1000) % random.nextDouble(1000);
        };

        int numThreads = 100000;

        long start = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            Thread.startVirtualThread(runnable);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time (Run with virtual threads): " + (finish - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            new Thread(runnable).start();
        }
        finish = System.currentTimeMillis();
        System.out.println("Time (Run with normal threads): " + (finish - start));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadVirtual threadVirtual = new ThreadVirtual();
        threadVirtual.createVirtualThread();
//        threadVirtual.usingExecutorService();
//        threadVirtual.testPerformance();

    }
}
