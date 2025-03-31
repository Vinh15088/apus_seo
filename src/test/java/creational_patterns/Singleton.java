package creational_patterns;

import lombok.extern.slf4j.Slf4j;
import org.example.creational_patterns.singleton.BillPugh;
import org.example.creational_patterns.singleton.Eager;
import org.example.creational_patterns.singleton.Lazy;
import org.example.creational_patterns.singleton.ThreadSafe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j(topic = "TEST_SINGLETON")
public class Singleton {

    @Test
    public void givenEager_whenCallGetInstance_thenReturnSingletonInstance() {
        // storage instances of Eager
        Set<Eager> set = new HashSet<>();
        // list future, get results from the execution stream
        List<Future<Eager>> futures = new ArrayList<>();

        // create a thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // task: get instance of eager
        Callable<Eager> runnableTask = () -> {
            log.info("run called for: {}", Thread.currentThread().getName());
            return Eager.getInstance();
        };

        int count = 0;

        // add instance to futures
        while (count < 5) {
            futures.add(executorService.submit(runnableTask));
            count++;
        }

        // add instance to set
        futures.forEach(future -> {
            try {
                set.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        // close thread pool
        executorService.shutdown();

        assertEquals(1, set.size());
    }

    @Test
    public void givenLazy_whenCallGetInstance_thenReturnSingletonInstance() throws ClassNotFoundException {
        Class bs = Class.forName("org.example.creational_patterns.singleton.Lazy");
//        assertThrows(IllegalAccessException.class, bs::getDeclaredConstructors);

        Lazy lazy1 = Lazy.getInstance();
        Lazy lazy2 = Lazy.getInstance();

        assertEquals(lazy1.hashCode(), lazy2.hashCode());
    }

    @Test
    public void givenLazy_whenMultipleThreadsAccess_thenReturnDifferentInstances() throws InterruptedException, ExecutionException {
        Set<Lazy> set = new HashSet<>();
        List<Future<Lazy>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<Lazy> task = () -> {
            log.info("run called for: {}", Thread.currentThread().getName());
            return Lazy.getInstance();
        };

        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(task));
        }

        futures.forEach(future -> {
            try {
                set.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();

        System.out.println("number of instances: " + set.size());

        assertTrue(set.size() > 1);
    }

    @Test
    public void givenBillPugh_whenMultipleThreadsAccess_thenReturnDifferentInstances() throws InterruptedException, ExecutionException {
        Set<BillPugh> set = new HashSet<>();
        List<Future<BillPugh>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<BillPugh> task = () -> {
            log.info("run called for: {}", Thread.currentThread().getName());
            return BillPugh.getInstance();
        };

        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(task));
        }

        futures.forEach(future -> {
            try {
                set.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();

        System.out.println("number of instances: " + set.size());
        assertTrue(set.size() == 1);
    }

    @Test
    public void givenThreadSafe_whenCallGetInstance_thenReturnSingletonInstance_threadPool() {
        Set<ThreadSafe> set = new HashSet<>();
        List<Future<ThreadSafe>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<ThreadSafe> runnableTask = () -> {
            log.info("run called for: {}", Thread.currentThread().getName());
//            return ThreadSafe.getInstance(); // thread safe
            return ThreadSafe.getInstanceDoubleLocking(); // double locking
        };


        int count = 0;
        while (count < 10) {
            futures.add(executorService.submit(runnableTask));
            count++;
        }

        futures.forEach(future -> {
            try {
                set.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
        assertEquals(1, set.size());
    }
}
