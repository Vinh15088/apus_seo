package org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.context;

public class UserContext {
    public static ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setUserId(String userId) {
        currentUser.set(userId);
    }

    public static String getUserId() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
