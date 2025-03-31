package org.example.creational_patterns.singleton;

public class ThreadSafe {

    // volatile => variable can change across threads
    private static volatile ThreadSafe INSTANCE;

    private ThreadSafe() {}

    // synchronized method
    @SuppressWarnings("InstantiationOfUtilityClass")
    public static synchronized ThreadSafe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafe();
        }

        return INSTANCE;
    }

    // method using double locking => check for class existence
    @SuppressWarnings("InstantiationOfUtilityClass")
    public static ThreadSafe getInstanceDoubleLocking() {
        if (INSTANCE == null) {
            synchronized (ThreadSafe.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafe();
                }
            }
        }

        return INSTANCE;
    }
}
