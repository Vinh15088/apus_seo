package org.example.reflection.reflectionTest;

import org.example.reflection.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> classCat = Class.forName("org.example.reflection.Cat");

        Cat tom1 = new Cat("Tom1", 1);
        System.out.println("Cat 1: " + tom1.getName() + ", age: " + tom1.getAge());

        // get public method
        Method getNameMethod = classCat.getMethod("getName");

        // call method getName with reflect
        String name = (String) getNameMethod.invoke(tom1);
        System.out.println("Get name: " + name);

        // get private method
        Method setAgeMethod = classCat.getDeclaredMethod("setAge", int.class);

        // call private method setAge with reflect
        setAgeMethod.setAccessible(true);
        setAgeMethod.invoke(tom1, 2);
        System.out.println("Cat 1: " + tom1.getName() + ", age: " + tom1.getAge());

        // return type of method getName
        Class<?> returnType = getNameMethod.getReturnType();
        System.out.println("Return type of getName: " + returnType);



        // get all method in class Cat
        System.out.println("\nDeclared Methods:");
//        Method[] methods = classCat.getMethods(); // get public method
        Method[] methods = classCat.getDeclaredMethods(); // all modifier
        for (Method method : methods) {
            System.out.print(method.getName() + " + ");
        }
        System.out.println();
    }
}
