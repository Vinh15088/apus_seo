package org.example.reflection.reflectionTest;

import org.example.reflection.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> classCat = Class.forName("org.example.reflection.Cat");

        // get constructors in class Cat
        Constructor<?>[] constructors = classCat.getConstructors();

        for (Constructor<?> constructor : constructors) {
            // get name, number of parameter in constructor
            System.out.println("+ " + constructor.getName() + " has " + constructor.getParameterCount() + " param");

            // get parameter type
            System.out.print("Get parameters type: ");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for(Class<?> parameterType : parameterTypes){
                System.out.print(parameterType.getSimpleName() + " ");
            }
            System.out.println();
        }

        // init normal constructor
        Cat tom1 = new Cat("Tom1", 1);
        System.out.println("Cat 1: " + tom1.getName() + ", age: " + tom1.getAge());

        // init reflect constructor
        Constructor<?> constructor = classCat.getConstructor(String.class, int.class);
        Cat tom2 = (Cat) constructor.newInstance("Tom2", 2);
        System.out.println("Cat 2: " + tom2.getName() + ", age: " + tom2.getAge());
    }
}
