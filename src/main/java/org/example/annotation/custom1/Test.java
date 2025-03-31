package org.example.annotation.custom1;

import org.example.annotation.User;

public class Test {
    public static void main(String[] args) {
        testValidPhone();
        testInvalidPhone();
        testNullPhone();
    }

    public static void testValidPhone() {
        User user = new User("+1234567890");
        boolean isValid = validateUser(user);
        System.out.println("Test valid phone: " + (isValid ? "Passed" : "Failed"));
    }

    public static void testInvalidPhone() {
        User user = new User("12345");
        boolean isValid = validateUser(user);
        System.out.println("Test invalid phone: " + (isValid ? "Passed" : "Failed"));
    }

    public static void testNullPhone() {
        User user = new User(null);
        boolean isValid = validateUser(user);
        System.out.println("Test null phone: " + (isValid ? "Passed" : "Failed"));
    }

    private static boolean validateUser(User user) {
        String phoneRegex = "^\\+?[0-9]{10}$";
        return user.getPhone() != null && user.getPhone().matches(phoneRegex);
    }
}
