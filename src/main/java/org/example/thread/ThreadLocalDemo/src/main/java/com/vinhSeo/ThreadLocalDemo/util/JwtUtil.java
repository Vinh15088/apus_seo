package org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.util;

public class JwtUtil {

    public static String extractUserId(String token) {
        if(token != null) {
            return token.substring(7);
        }

        return null;
    }
}
