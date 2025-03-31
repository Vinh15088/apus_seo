package org.example.creational_patterns.singleton.problem;

import java.io.Serial;
import java.io.Serializable;

public class Serialized implements Serializable{
    @Serial
    private static final long serialVersionUID = 45678L;

    private Serialized() {}

    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    private static class SingletonHelper {
        private static final Serialized instance = new Serialized();
    }

    public static Serialized getInstance() {
        return SingletonHelper.instance;
    }
}
