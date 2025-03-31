package org.example.creational_patterns.singleton;

public class Eager {

    @SuppressWarnings("InstantiationOfUtilityClass")
    private static final Eager INSTANCE = new Eager();

    // private constructor
    private Eager() {}

    // getInstance
    public static Eager getInstance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return INSTANCE;
    }
}
