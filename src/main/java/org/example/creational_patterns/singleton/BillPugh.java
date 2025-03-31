package org.example.creational_patterns.singleton;

// or call Static inner class
public class BillPugh {

    private BillPugh() {}

    public static BillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    private static class SingletonHelper {
        private static final BillPugh INSTANCE = new BillPugh();
    }
}
