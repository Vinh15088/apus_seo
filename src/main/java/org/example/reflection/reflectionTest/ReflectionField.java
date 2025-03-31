package org.example.reflection.reflectionTest;

import org.example.reflection.Cat;

import java.lang.reflect.Field;

public class ReflectionField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class<?> classCat = Class.forName("org.example.reflection.Cat");

        // get public field with name
        Field field = classCat.getField("NUMBER_OF_LEGS");
        System.out.println(field.getName());

        // get field (private, protected, public)
        Field private_nameField = classCat.getDeclaredField("name");
        System.out.println(private_nameField.getName());

        // get type field
        Class<?> fieldType = field.getType();
        System.out.println("Number of legs: " + fieldType.getSimpleName());

        // get all public fields
        System.out.print("Public fields: ");
        Field[] fields = classCat.getFields();
        for (Field field2 : fields) {
            System.out.print(field2.getName() + ", ");
        }

        // get all fields
        System.out.println();
        System.out.print("All fields: ");
        Field[] fields2 = classCat.getDeclaredFields();
        for (Field field2 : fields2) {
            System.out.print(field2.getName() + ", ");
        }

        // set new value in private field
        Cat tom1 = new Cat("Tom1", 1);
        System.out.println("Cat 1: " + tom1.getName() + ", age: " + tom1.getAge());
        private_nameField.setAccessible(true);
        private_nameField.set(tom1, "Tom1 new");
        System.out.println("Cat 1: " + tom1.getName() + ", age: " + tom1.getAge());

    }
}
