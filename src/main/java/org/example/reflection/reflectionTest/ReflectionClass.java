package org.example.reflection.reflectionTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> classCat = Class.forName("org.example.reflection.Cat");

        // get name
        System.out.println("Name: " + classCat.getName());
        System.out.println("Simple Name: " + classCat.getSimpleName());

        // get packet name
        Package pkg = classCat.getPackage();
        System.out.println("Package Name = " + pkg.getName());

        // modifier of class cat
        int modifiers = classCat.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);

        System.out.println("Is Public? " + isPublic); // true
        System.out.println("Is Final? " + isFinal); // false
        System.out.println("Is Interface? " + isInterface); // false
        System.out.println("Is Abstract? " + isAbstract); // false

        // get super class in class Cat
        Class<?> aSuperClass = classCat.getSuperclass();
        System.out.println("Simple Class Name of Super class = " + aSuperClass.getSimpleName());

        // get interface implemented in class Cat
        System.out.println("\nInterface:");
        Class<?>[] itfClasses = classCat.getInterfaces();
        for (Class<?> itfClass : itfClasses) {
            System.out.println("+ " + itfClass.getSimpleName());
        }


        // get annotations
        System.out.println("\nAnnotation:");
        Annotation[] annotations = classCat.getAnnotations();
        for (Annotation ann : annotations) {
            System.out.println("+ " + ann.annotationType().getSimpleName());
        }

//        Method method = classCat.getMethod("nonExistingMethod");
    }
}
