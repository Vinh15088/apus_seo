package org.example.creational_patterns.singleton;

public class Lazy {

    private static Lazy instance;

    private Lazy() {}

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static Lazy getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Lazy();
        }

        return instance;
    }
}
