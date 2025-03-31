package org.example.creational_patterns.singleton;

@SuppressWarnings("InstantiationOfUtilityClass")
public class StaticBlock {
    private static final StaticBlock INSTANCE;

    private StaticBlock() {}

    static {
        try {
            INSTANCE = new StaticBlock();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static StaticBlock getInstance() {
        return INSTANCE;
    }
}
